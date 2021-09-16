import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
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
        List<Transaction> getByStatusList = transactions.values()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());

        if(getByStatusList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return getByStatusList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> sendersByStatusList = transactions.values()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        if(sendersByStatusList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return sendersByStatusList;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> receiversByStatusList = transactions.values()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        if(receiversByStatusList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return receiversByStatusList;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactions.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {

        List<Transaction> getBySender = transactions.values()
                .stream()
                .filter(t -> t.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if(getBySender.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return getBySender;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> getByReceiver = transactions.values()
                .stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if(getByReceiver.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return getByReceiver;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return transactions.values()
                .stream()
                .filter(t -> t.getStatus().equals(status) && t.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> getBySenderAndMinAmount = transactions.values()
                .stream()
                .filter(t -> t.getFrom().equals(sender) && t.getAmount() >= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if(getBySenderAndMinAmount.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return getBySenderAndMinAmount;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {

        List<Transaction> getByReceiverAndAmountRange = transactions.values()
                .stream()
                .filter(t -> t.getTo().equals(receiver) && t.getAmount() >= lo && t.getAmount() < hi)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if(getByReceiverAndAmountRange.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return getByReceiverAndAmountRange;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return transactions.values()
                .stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
