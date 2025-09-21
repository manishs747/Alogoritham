package design_problems.wallet;

public class UPIPayment implements PaymentMethod{
    @Override
    public boolean pay(double amount, Wallet from, Wallet to) {
        if (from.debit(amount)) {
            to.credit(amount);
            return true;
        }
        return false;
    }
}
