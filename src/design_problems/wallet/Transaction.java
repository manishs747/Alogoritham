package design_problems.wallet;

public class Transaction {
    private final String txnId;
    private final String fromUserId;
    private final String toUserId;
    private final double amount;
    private final TxnStatus status;
    private final long timestamp;

    public Transaction(String txnId, String fromUserId, String toUserId,
                       double amount, TxnStatus status) {
        this.txnId = txnId;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.amount = amount;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

}
