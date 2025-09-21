package design_problems.grocking.parkinglot;

import design_problems.grocking.parkinglot.vechiles.Vehicle;

import java.util.Date;

public class ParkingTicket {
    private int ticketNo;
    private Date entryTime;
    private Date exitTime;
    private double amount;
    private TicketStatus status;

    private Vehicle vehicle;
    private Payment payment; // Composition: Ticket owns Payment
    private Entrance entrance;
    private Exit exitIns;

}
