import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private static final int ID = 0;
    private static final TransactionStatus STATUS = TransactionStatus.UNAUTHORIZED;
    private static final String SENDER = "Sender";
    private static final String RECEIVER = "Receiver";
    private static final Double AMOUNT = 50.0;
    private static final Double LO = 25.20;
    private static final Double HI = 65.20;

    private Chainblock chainblock;
    private List<Transaction> transactions;
    private TransactionImpl defaultTransaction;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        this.defaultTransaction = new TransactionImpl(ID, STATUS, SENDER, RECEIVER, AMOUNT);
    }

    private void stubTransactions() {
        List<Transaction> list= Arrays.asList(
                new TransactionImpl(1,TransactionStatus.SUCCESSFUL, SENDER, RECEIVER, HI),
                new TransactionImpl(2,TransactionStatus.UNAUTHORIZED, "Peter", "Petrov", LO),
                new TransactionImpl(3,TransactionStatus.FAILED, SENDER, RECEIVER, LO),
                new TransactionImpl(4,TransactionStatus.UNAUTHORIZED, "Peter", "Petrov", 111.10),
                new TransactionImpl(5,TransactionStatus.FAILED, "Alexander", "The Great", LO),
                new TransactionImpl(6,TransactionStatus.UNAUTHORIZED, SENDER, RECEIVER, 40.20)
        );

        for (Transaction transaction : list) {
            chainblock.add(transaction);
            transactions.add(transaction);
        }
    }

    @Test
    public void testContainsTransactionShouldReturnFalseWhenTransactionIsAbsentAndTrueWhenIsPresent() {
        assertFalse(chainblock.contains(defaultTransaction));
        chainblock.add(defaultTransaction);
        assertTrue(chainblock.contains(defaultTransaction));
    }

    @Test
    public void testAddTransactionShouldAddTransactionInChainblock() {
        chainblock.add(defaultTransaction);
        assertEquals(1, chainblock.getCount());
        chainblock.add(new TransactionImpl(1, TransactionStatus.FAILED, "Sender", "Receiver", 10));
        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testAddShouldNotAddTransactionWithSameIdTwice() {
        chainblock.add(defaultTransaction);
        assertEquals(1, chainblock.getCount());
        chainblock.add(defaultTransaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowIfTheGivenTransactionIsAbsent() {
        chainblock.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testChangeTransactionStatusOnTransactionById() {
        chainblock.add(defaultTransaction);
        chainblock.changeTransactionStatus(ID, TransactionStatus.SUCCESSFUL);
        assertEquals(TransactionStatus.SUCCESSFUL, defaultTransaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowWhenNoSuchIdInChainblock() {
        chainblock.removeTransactionById(chainblock.getCount() + 1);
    }

    @Test
    public void testRemoveTransactionByIdShouldRemoveValidTransaction() {
        chainblock.add(defaultTransaction);
        chainblock.removeTransactionById(ID);
        assertEquals(0, chainblock.getCount());
        assertFalse(chainblock.contains(ID));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrowWhenNoSuchIdInChainblock() {
        chainblock.getById(chainblock.getCount() + 1);
    }

    @Test
    public void testGetByIdShouldReturnValidTransaction() {
        chainblock.add(defaultTransaction);
        assertEquals(defaultTransaction, chainblock.getById(ID));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusThrowWhenTransactionWithTheGivenStatusIsAbsent() {
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatusReturnValidNumberOfTransactions() {
        stubTransactions();
        transactions = createListFromIterable(chainblock.getByTransactionStatus(TransactionStatus.FAILED));
        assertEquals(2, transactions.size());
    }

    @Test
    public void testGetByTransactionStatusReturnTransactionsByAmountDescending() {
        stubTransactions();
        List<Transaction> getByStatusList = createListFromIterable(
                chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED));
        List<Transaction> expected = getByStatusList.stream()
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());

        assertEquals(expected, getByStatusList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusThrowWhenNoSuchTransactionPresent() {
        stubTransactions();
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllSendersByTransactionStatusReturnValidNumberOfSenders() {
        stubTransactions();
        List<String> senders = createListOfStringFromIterable(
                chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED));
        assertEquals(2, senders.size());
    }

    @Test
    public void testGetAllSendersByTransactionStatusReturnSendersByTransactionAmountDescending() {
        stubTransactions();
        List<String> senders = createListOfStringFromIterable(
                chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED));

        List<String> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.UNAUTHORIZED))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        assertEquals(expected, senders);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusThrowWhenNoSuchTransactionPresent() {
        stubTransactions();
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllReceiversByTransactionStatusReturnValidNumberOfSenders() {
        stubTransactions();
        List<String> receivers = createListOfStringFromIterable(
                chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED));
        assertEquals(2, receivers.size());
    }

    @Test
    public void testGetAllReceiversByTransactionStatusReturnSendersByTransactionAmountDescending() {
        stubTransactions();
        List<String> receivers = createListOfStringFromIterable(
                chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED));

        List<String> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.UNAUTHORIZED))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        assertEquals(expected, receivers);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdReturnsCorrectAmountOfTransactions() {
        stubTransactions();
        List<Transaction> allTransactions = createListFromIterable(
                chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(transactions.size(), allTransactions.size());
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        stubTransactions();
        List<Transaction> allByAmountThenById = createListFromIterable(
                chainblock.getAllOrderedByAmountDescendingThenById());

        transactions = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        assertEquals(transactions, allByAmountThenById);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingThrowWhenTransactionWithGivenSenderIsAbsent() {
        chainblock.add(defaultTransaction);
        chainblock.getBySenderOrderedByAmountDescending("Somebody");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingReturnsCorrectAmountOfTransactions() {
        stubTransactions();
        List<Transaction> getBySender = createListFromIterable(
                chainblock.getBySenderOrderedByAmountDescending(SENDER));
        assertEquals(3, getBySender.size());
    }

    @Test
    public void testGetBySenderOrderedByAmountDescending() {
        stubTransactions();
        List<Transaction> getBySender = createListFromIterable(
                chainblock.getBySenderOrderedByAmountDescending(SENDER));

        List<Transaction> expected = getBySender.stream()
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());
        assertEquals(expected, getBySender);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdThrowWhenTransactionToGivenReceiverIsAbsent() {
        chainblock.add(defaultTransaction);
        chainblock.getByReceiverOrderedByAmountThenById("Somebody");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdReturnsCorrectAmountOfTransactions() {
        stubTransactions();
        List<Transaction> getByReceiver = createListFromIterable(
                chainblock.getByReceiverOrderedByAmountThenById(RECEIVER));
        assertEquals(3, getByReceiver.size());
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenById() {
        stubTransactions();
        List<Transaction> getByReceiver = createListFromIterable(
                chainblock.getByReceiverOrderedByAmountThenById(RECEIVER));

        List<Transaction> expected = getByReceiver.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        assertEquals(expected, getByReceiver);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountReturnEmptyCollectionWhenTransactionWithGivenStatusIsAbsent() {
        stubTransactions();
        List<Transaction> getByStatusAndMaxAmount = createListFromIterable(
                chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 10));
        assertTrue(getByStatusAndMaxAmount.isEmpty());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountReturnEmptyCollectionWhenTransactionWithGivenMaxAmountIsAbsent() {
        stubTransactions();
        List<Transaction> getByStatusAndMaxAmount = createListFromIterable(
                chainblock.getByTransactionStatusAndMaximumAmount(STATUS, 10));
        assertTrue(getByStatusAndMaxAmount.isEmpty());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountReturnCorrectCountOfTransactions() {
        stubTransactions();
        List<Transaction> getByStatusAndMaxAmount = createListFromIterable(
                chainblock.getByTransactionStatusAndMaximumAmount(STATUS, 50));
        assertEquals(2, getByStatusAndMaxAmount.size());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmount() {
        stubTransactions();
        List<Transaction> getByStatusAndMaxAmount = createListFromIterable(
                chainblock.getByTransactionStatusAndMaximumAmount(STATUS, AMOUNT));

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getStatus().equals(STATUS) && t.getAmount() <= AMOUNT)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(expected, getByStatusAndMaxAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingThrowWhenTransactionWithGivenMinAmountIsAbsent() {
        stubTransactions();
        chainblock.getBySenderAndMinimumAmountDescending(SENDER, 99999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingThrowWhenTransactionWithGivenSenderIsAbsent() {
        stubTransactions();
        chainblock.getBySenderAndMinimumAmountDescending("someone", 30);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingReturnCorrectCountOfTransactions() {
        stubTransactions();
        List<Transaction> getBySenderAndMinAmount = createListFromIterable(
                chainblock.getBySenderAndMinimumAmountDescending(SENDER, AMOUNT));
        assertEquals(1, getBySenderAndMinAmount.size());
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescending() {
        stubTransactions();
        List<Transaction> getBySenderAndMinAmount = createListFromIterable(
                chainblock.getBySenderAndMinimumAmountDescending(SENDER, AMOUNT));

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getFrom().equals(SENDER) && t.getAmount() >= AMOUNT)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(expected, getBySenderAndMinAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeThrowWhenTransactionWithGivenReceiverIsAbsent() {
        stubTransactions();
        chainblock.getByReceiverAndAmountRange("Somebody", 20, 40);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeThrowWhenTransactionWithAmountInGivenRangeIsAbsent() {
        stubTransactions();
        chainblock.getByReceiverAndAmountRange(RECEIVER, 10, 20);
    }

    @Test
    public void testGetByReceiverAndAmountRangeReturnCorrectCountOfTransactions() {
        stubTransactions();
        List<Transaction> getByReceiverAndAmountRange = createListFromIterable(
                chainblock.getByReceiverAndAmountRange(RECEIVER, 25.20, 65.20));
        assertEquals(2, getByReceiverAndAmountRange.size());
    }

    @Test
    public void testGetByReceiverAndAmountRangeReturnTransactionsOrderedByAmountDescendingAndById() {

        stubTransactions();
        List<Transaction> getByReceiverAndAmountRange = createListFromIterable(
                chainblock.getByReceiverAndAmountRange(RECEIVER, LO, HI));

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getTo().equals(RECEIVER) && t.getAmount() >= LO && t.getAmount() < HI)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        assertEquals(expected, getByReceiverAndAmountRange);
    }

    @Test
    public void testGetAllInAmountRangeReturnEmptyCollectionWhenNoTransactionsWithAmountInGivenRange() {
        stubTransactions();
        List<Transaction> getAllInRange = createListFromIterable(
                chainblock.getAllInAmountRange(10, 20));
        assertTrue(getAllInRange.isEmpty());
    }

    @Test
    public void testGetAllInAmountRangeReturnCorrectCountOfTransactions() {
        stubTransactions();
        List<Transaction> getAllInRange = createListFromIterable(
                chainblock.getAllInAmountRange(LO, HI));
        assertEquals(5, getAllInRange.size());
    }


    private List<String> createListOfStringFromIterable(Iterable<String> iterable) {
        assertNotNull(iterable);
        List<String> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    private List<Transaction> createListFromIterable(Iterable<Transaction> iterable) {
        assertNotNull(iterable);
        List<Transaction> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}