package design_problems.grocking.parkinglot;

public class CreditCard extends Payment{
    @Override
    public boolean initiateTransaction() {
        return false;
    }
}
