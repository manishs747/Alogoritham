package design_problems.wallet;

public class User {

    private final String userId;
    private final String name;

    private final Wallet wallet;

    public User(String userId,String name, Wallet wallet){
        this.userId = userId;
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getUserId() {
        return userId;
    }
}
