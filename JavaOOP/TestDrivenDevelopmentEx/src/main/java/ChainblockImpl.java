import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new HashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        transactions.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if(!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        transactions.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if(!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        transactions.remove(id);
    }

    public Transaction getById(int id) {
        if(!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        return transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> list = transactions.values()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());

        if(list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
