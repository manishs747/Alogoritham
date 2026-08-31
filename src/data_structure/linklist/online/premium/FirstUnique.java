package data_structure.linklist.online.premium;

import java.util.*;

/**
 * https://leetcode.com/problems/first-unique-number/?envType=company&envId=uber&favoriteSlug=uber-thirty-days
 */
public class FirstUnique {

    Queue<Integer> list = new LinkedList<>();
    Map<Integer,Integer> memo = new HashMap<>();
    public FirstUnique(int[] nums) {
        for (int num: nums){
            list.add(num);
            memo.put(num,memo.getOrDefault(num,0)+1);
        }
    }

    public int showFirstUnique() {
        while (!list.isEmpty()){
            if(memo.get(list.peek()) == 1){
                return list.peek();
            }else {
                list.remove();
            }
        }
        return -1;
    }

    public void add(int value) {
        memo.put(value,memo.getOrDefault(value,0)+1);
      if(memo.getOrDefault(value,0)  <= 1){
          list.add(value);
      }
    }
}
