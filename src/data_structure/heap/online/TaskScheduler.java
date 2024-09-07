package data_structure.heap.online;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
                char [] arr = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(arr,1));//10

        //"A","A","A","A","A","A","B","C","D","E","F","G"
    }


    public static int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> charCount = new HashMap<>();
        for (char c :tasks)
            charCount.put(c,charCount.getOrDefault(c,0)+1);
        int count = 0;
        while (true){
            int num = n+1;
            Queue<Character> list = new LinkedList<>();
            for (char c:charCount.keySet()) {
                if(charCount.get(c) == 0) continue;
                count++;
                num --;
                charCount.put(c,charCount.get(c)-1);
                if(charCount.get(c) == 0){
                    list.add(c);
                }
            }
            while (!list.isEmpty()){
                charCount.remove(list.poll());
            }
            if(charCount.isEmpty()) break;
            count += num > 0 ? num : 0;
        }
        return count;
    }
}
