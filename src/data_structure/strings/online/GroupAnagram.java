package data_structure.strings.online;

import utils.ArrayUtils;

import java.util.*;

public class GroupAnagram {


    public static void main(String[] args) {
           String strs [] = {"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(strs));
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str:strs) {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars),k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
