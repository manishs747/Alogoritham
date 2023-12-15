package data_structure.arrays.online;

import java.util.*;

public class RandomizedSet {

    Map<Integer,Integer> set = new HashMap<>();
    ArrayList<Integer> list  = new ArrayList<>();

    Random random = new Random();



    public static void main(String[] args) {

    }

    public RandomizedSet() {
    }

    public boolean insert(int val) {
       if(set.containsKey(val)) return false;
        list.add(val);
        set.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (! set.containsKey(val)) return false;

        // move the last element to the place idx of the element to delete
        int lastElement = list.get(list.size() - 1);
        int idx = set.get(val);
        list.set(idx, lastElement);
        set.put(lastElement, idx);
        // delete the last element
        list.remove(list.size() - 1);
        set.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()-1)) ;
    }
}
