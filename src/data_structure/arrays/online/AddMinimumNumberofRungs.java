package data_structure.arrays.online;


/**
 * https://leetcode.com/problems/add-minimum-number-of-rungs/
 */
public class AddMinimumNumberofRungs {
    public static void main(String[] args) {

    }


    public static int addRungs1(int[] rungs, int dist) {
        int count = 0, prev = 0;
        for (int rug : rungs) {
            count += (rug - prev - 1) / dist;
            prev = rug;
        }
        return count;
    }

    public int addRungs(int[] rungs, int dist) {
        int count = (rungs[0] - 1) / dist;
        for (int i = 1; i < rungs.length; i++) {
            if(rungs[i]-rungs[i-1] > dist){
                count += (rungs[i] - rungs[i - 1] - 1) / dist;
            }
        }
        return count;
    }


    public int addRungs3(int[] rungs, int dist) {
        int i,count = (rungs[0] - 1) / dist;
        for(i = 1; i< rungs.length;i++){
            if(rungs[i]-rungs[i-1] > dist){
                count+= (rungs[i]-rungs[i-1])/dist;
                if((rungs[i]-rungs[i-1])%dist == 0) count-=1;
            }
        }
        return count;
    }
}
