import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private static final int ID = 0;
    private static final TransactionStatus STATUS = TransactionStatus.UNAUTHORIZED;
    private static final String SENDER = "Sender";
    private static final String RECEIVER = "Receiver";
    private static final Double AMOUNT = 25.5;

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
                new TransactionImpl(1,TransactionStatus.SUCCESSFUL, "Sender", "Receiver", 25.20),
                new TransactionImpl(2,TransactionStatus.UNAUTHORIZED, "Sender", "Receiver", 25.20),
                new TransactionImpl(3,TransactionStatus.FAILED, "Sender", "Receiver", 25.20),
                new TransactionImpl(4,TransactionStatus.UNAUTHORIZED, "Sender", "Receiver", 111.10),
                new TransactionImpl(5,TransactionStatus.FAILED, "Sender", "Receiver", 25.20),
                new TransactionImpl(6,TransactionStatus.UNAUTHORIZED, "Sender", "Receiver", 40.20)
        );

        for (Transaction transaction : list) {
            chainblock.add(transaction);
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
        transactions = createListFromIterable(chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED));
        List<Transaction> expected = transactions.stream()
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());

        assertEquals(expected, transactions);
    }

    private List<Transaction> createListFromIterable(Iterable<Transaction> iterable) {
        assertNotNull(iterable);
        List<Transaction> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}