package design_problems.parkinlot;

public class Level {
	private int floor;
	private ParkingSpot[ ] spots;
	private int availableSpots = 0; // number of free spots
	private static final int SPOTS_PER_ROW = 10;
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public ParkingSpot[] getSpots() {
		return spots;
	}
	public void setSpots(ParkingSpot[] spots) {
		this.spots = spots;
	}
	public int getAvailableSpots() {
		return availableSpots;
	}
	public void setAvailableSpots(int availableSpots) {
		this.availableSpots = availableSpots;
	}
	public static int getSpotsPerRow() {
		return SPOTS_PER_ROW;
	}
}
