package design_problems.grocking.parkinglot;

import java.util.Date;

public abstract class Payment {
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    public abstract boolean initiateTransaction();

}
