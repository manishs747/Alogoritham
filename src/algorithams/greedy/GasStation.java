package algorithams.greedy;

/**
 * https://leetcode.com/problems/gas-station/description/
 */
public class GasStation {

    public static void main(String[] args) {
       int [] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        //Output: 3
        System.out.println(canCompleteCircuit(gas,cost));
    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0 , curgas = 0, start = 0;
        for (int i = 0; i <  gas.length; i++) {
            curgas += gas[i]-cost[i];
            totalgas += gas[i]-cost[i];
            if(curgas < 0){
                start = i + 1;
                curgas = 0;
            }
        }
        return totalgas < 0 ? -1 : start;
    }

}
