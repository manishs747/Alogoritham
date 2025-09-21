package design_problems.grocking.parkinglot;

public class Cash extends Payment{
    @Override
    public boolean initiateTransaction() {
        return false;
    }
}
