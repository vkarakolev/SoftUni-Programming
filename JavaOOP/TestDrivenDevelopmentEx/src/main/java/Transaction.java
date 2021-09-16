public interface Transaction {

    public int getId();

    public TransactionStatus getStatus();

    void setStatus(TransactionStatus status);

    double getAmount();

    String getFrom();

    String getTo();
}
