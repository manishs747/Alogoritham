package data_structure.stack;


import java.util.Stack;

/**
 * https://leetcode.com/problems/make-the-string-great/?envType=daily-question&envId=2024-04-05
 */
public class MakeGood {

    public static void main(String[] args) {
        String s = "AbBAcC";
        System.out.println(makeGood(s));

    }


    public  static String makeGood(String s) {
        if(s.length() < 2) return s;
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()) {
               boolean isGood = isGood(stack,c);
              if(isGood){  // if equal and are not same case
                  stack.pop();
              }else{
                  stack.add(c);
              }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : stack) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    private static boolean isGood(Stack<Character> stack, char c) {
        if (stack.isEmpty()) return false;
        char peeked = stack.peek();
        return Character.toLowerCase(c) == Character.toLowerCase(peeked) &&
                ((Character.isUpperCase(c) && Character.isLowerCase(peeked)) ||
                        (Character.isLowerCase(c) && Character.isUpperCase(peeked)));
    }
}
