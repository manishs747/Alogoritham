package design_problems.grocking.parkinglot;

import design_problems.grocking.parkinglot.parkingspot.ParkingSpot;

import java.util.List;
import java.util.Map;

public class DisplayBoard {
    private int id;
    private Map<String, List<ParkingSpot>> parkingSpots;

    public DisplayBoard(int id) { /* ... */ }
    public void addParkingSpot(String spotType, List<ParkingSpot> spots) { /* ... */ }
    public void showFreeSlot() { /* ... */ }
}
