package design_problems.grocking.parkinglot.parkingspot;

import design_problems.grocking.parkinglot.vechiles.Vehicle;

public class Handicapped extends ParkingSpot  {
    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        return false;
    }
}
