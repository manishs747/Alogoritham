package design_problems.grocking.parkinglot.vechiles;

import design_problems.grocking.parkinglot.ParkingTicket;

public abstract class Vehicle {
    private String licenseNo;
    private ParkingTicket ticket;

    public abstract void assignTicket(ParkingTicket ticket);


}
