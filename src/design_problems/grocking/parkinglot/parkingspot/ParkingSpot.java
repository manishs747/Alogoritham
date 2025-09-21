package design_problems.grocking.parkinglot.parkingspot;

import design_problems.grocking.parkinglot.vechiles.Vehicle;

public abstract class ParkingSpot {

    private int id;
    private boolean isFree;

    private Vehicle vehicle; // Association: Each spot can be assigned to one vehicle

    public abstract boolean assignVehicle(Vehicle vehicle);

    public boolean removeVehicle() {
        // Logic to remove vehicle from spot and mark as free
        return true;
    }





}
