package design_problems.wallet;

public class Wallet {
    private final String walletId;
    private double balance;

    public Wallet(String walletId){
        this.walletId = walletId;
    }

    public synchronized void credit(double amount){
        balance += amount;
    }

    public synchronized  boolean debit(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance(){
        return balance;
    }
}
