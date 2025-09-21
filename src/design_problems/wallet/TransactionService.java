package design_problems.wallet;

import java.util.UUID;

public class TransactionService {

    private final NotificationService notificationService = new NotificationService();


    public Transaction transfer(User from , User to , double amount , PaymentMethod paymentMethod){
        boolean success = paymentMethod.pay(amount,from.getWallet(),to.getWallet());
        Transaction txn = new Transaction(
                UUID.randomUUID().toString(),
                from.getUserId(),
                to.getUserId(),
                amount,
                success ? TxnStatus.SUCCESS : TxnStatus.FAILED
        );
        if(success){
            notificationService.sendNotification(to, "Received " + amount + " from " + from.getUserId());
            notificationService.sendNotification(from, "Sent " + amount + " to " + to.getUserId());
        }
        return txn;
    }

    public Transaction addMoney(User user, double amount, PaymentMethod method) {
        boolean success = method.pay(amount, new Wallet("Bank"), user.getWallet());
        return new Transaction(
                UUID.randomUUID().toString(),
                "BANK",
                user.getUserId(),
                amount,
                success ? TxnStatus.SUCCESS : TxnStatus.FAILED
        );
    }
}
