package designProblem.parkinlot;

public class Motorcycle extends Vehicle {
	
	public Motorcycle() {
		spotsNeeded = 1;
		size = VehicleSize.SMALL; }

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}

}
