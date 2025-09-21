package design_problems.grocking.parkinglot;

import design_problems.grocking.parkinglot.Account;
import design_problems.grocking.parkinglot.DisplayBoard;
import design_problems.grocking.parkinglot.Entrance;
import design_problems.grocking.parkinglot.Exit;
import design_problems.grocking.parkinglot.parkingspot.ParkingSpot;

public class Admin extends Account {
    @Override
    public boolean resetPassword() {
        return false;
    }

    public boolean addParkingSpot(ParkingSpot spot) { /* ... */ return true; }
    public boolean addDisplayBoard(DisplayBoard board) { /* ... */ return true; }
    public boolean addEntrance(Entrance entrance) { /* ... */ return true; }
    public boolean addExit(Exit exit) { /* ... */ return true; }
}
