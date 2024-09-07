package data_structure.arrays.online;


/**
 * https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150
 */
public class GasStation {

    public static void main(String[] args) {
        int [] gas = {3,1,1}, cost = {1,2,2};  // Output: 3
        System.out.println(canCompleteCircuit(gas,cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0 ,totalCost = 0 ,tank = 0 ,startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            // If tank is negative, reset the start index and tank
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        if (totalGas < totalCost) return -1;
        return startIndex;
    }



    public static int  canCompleteCircuit2(int[] gas, int[] cost) {
        int LEN = gas.length;
        for (int i = 0;i < LEN ;i++) {
            int tank = 0 , flag = 0;
            for (int j = 0; j < LEN; j++) {
                int c = (i + j) % LEN;
                tank += gas[c] - cost[c];
                if(tank < 0) {
                    flag = -1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;
    }
}
