package data_structure.arrays.online;

import java.util.ArrayList;
import java.util.List;

public class TestForLoop {


    public static void main(String[] args) {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largest = 1;
        for(int candy : candies)
            largest = largest < candy ? candy : largest;
        List<Boolean> list = new ArrayList<>(candies.length);
        for(int candy : candies)
            list.add(largest <= candy + extraCandies ? true : false);
        return list;
    }
}
