package data_structure.arrays.online;


/**
 * https://leetcode.com/problems/three-consecutive-odds/?envType=daily-question&envId=2024-07-01
 */
public class ThreeConsecutiveOdds {
    public static void main(String[] args) {

    }


    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int n:arr) {
            if(n%2 == 1){
                count++;
            }else {
                count = 0;
            }
            if(count == 3) return true;
        }
        return false;
    }
}
