package designProblem.parkinlot;

public class Car extends Vehicle {
	
	public Car() {
		spotsNeeded = 1;
		size = VehicleSize.MEDIUM;
		}

	/* Checks if the spot is a Compact or a Large. */
	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}

}
