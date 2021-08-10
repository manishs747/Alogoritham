package genricProblems;

import java.util.HashMap;
import java.util.Map;

public class RomanInteger {

    private final static Map<Character, Integer> map = new HashMap<>();

    static { map.put('I', 1);map.put('V', 5);map.put('X', 10);map.put('L', 50);map.put('C', 100);map.put('D', 500);map.put('M', 1000);
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";//1994
        System.out.println(romanToIntTer(s));
    }


    public static int romanToInt(String s) {
        int sum = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int curVal = map.get(s.charAt(i));
            int prevVal = map.get(s.charAt(i + 1));
            if (curVal < prevVal) {
                sum -= curVal;
            } else {
                sum += curVal;
            }
        }
        return sum;
    }

    public static int romanToIntTer(String s) {
        int sum = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            sum += map.get(s.charAt(i)) < map.get(s.charAt(i + 1)) ? -map.get(s.charAt(i)) : map.get(s.charAt(i));
        }
        return sum;
    }
}
