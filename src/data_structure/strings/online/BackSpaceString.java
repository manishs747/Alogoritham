package data_structure.strings.online;

import java.util.Stack;

public class BackSpaceString {

    public static void main(String[] args) {

       String s = "ab#c", t = "ad#c";
       System.out.println(backspaceCompare(s,t));

    }


    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = extracted(s) , s2 = extracted(t);
        if(s1.size() != s2.size()) return false;
        while (s1.size() > 0){
            if(!s1.pop().equals(s2.pop())) return false;
        }
        return true;
    }

    private static Stack<Character> extracted(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if(c == '#') {
                if (!stack.isEmpty()) stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack;
    }

    public static boolean backspaceCompare2(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private static String buildString(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1); // Remove the last character
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }


}
