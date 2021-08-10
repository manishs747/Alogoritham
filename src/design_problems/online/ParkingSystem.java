package design_problems.online;


/**
 * https://leetcode.com/problems/design-parking-system/
 */
public class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return slots[carType - 1]-- > 0;
    }
}
