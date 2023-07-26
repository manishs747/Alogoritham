package data_structure.strings.online;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UncommonFromSentences {
    public static void main(String[] args) {
       String s1 = "this apple is sweet", s2 = "this apple is sour";
    ArrayUtils.print(uncommonFromSentences(s1,s2));
    }


    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String str : (s1 + " " + s2).split("\\s+"))
            wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);
        ArrayList<String> list = new ArrayList<>();
        for (String key : wordCount.keySet()) {
            if (wordCount.get(key) == 1) list.add(key);
        }
        return list.toArray(new String[list.size()]);
    }

}
