package design_problems.wallet;

public class CardPayment implements PaymentMethod{
    @Override
    public boolean pay(double amount, Wallet from, Wallet to) {
        // Assume card verification logic
        if (from.debit(amount)) {
            to.credit(amount);
            return true;
        }
        return false;
    }
}
