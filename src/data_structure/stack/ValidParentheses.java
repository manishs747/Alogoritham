package data_structure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
       String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
       Map<Character,Character> map = new HashMap<>();
       map.put( ')','(');
        map.put( '}','{');
        map.put( ']','[' );
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()) {
            if(map.containsKey(c)){
               if(stack.isEmpty() || stack.peek() != (map.get(c))) return false;
               stack.pop();
            }else{
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
