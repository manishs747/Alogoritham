package data_structure.tree.online;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Advaith {


    public static void main(String[] args) {




        String name = "ADVAITH";
        for (int i = 1; i <= 10 ; i++) {
            for(int j = 1; j < i ; j++){
                System.out.print(name + " ");
            }
            System.out.println(name);

        }

    }


    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums)
            set.add(num);
        int max = -1;
        for (int num:nums) {
            if(num <= 0 ) continue;
            if(set.contains(-num)) max = Math.max(max,num);
        }
        return max;
    }
}
