package design_problems.wallet;

public interface PaymentMethod {
    boolean pay(double amount , Wallet from , Wallet to);
}
