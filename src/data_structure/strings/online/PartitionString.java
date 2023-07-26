package data_structure.strings.online;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/optimal-partition-of-string/description/
 */
public class PartitionString {

    public static void main(String[] args) {
       String s = "abacaba";
       System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        int result = 1;
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
           if (set.contains(c)){
               set.clear();
               set.add(c);
               result++;
           }else{
               set.add(c);
           }
        }
        return result;
    }
}
