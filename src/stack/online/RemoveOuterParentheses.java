package stack.online;

import java.util.Arrays;
import java.util.Stack;

/*
  https://leetcode.com/problems/remove-outermost-parentheses/
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {

        System.out.println(removeOuterParenthesesnew("(()())(())(()(()))"));
    }


    public static String removeOuterParentheses(String S) {
        char[] parens = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        for (char p : parens) {
            if (s.empty()) {
                s.push(p);
            } else {
                if (p == '(') {
                    s.push(p);
                    sb.append(p);
                } else {
                    s.pop();
                    if (!s.empty()) {
                        sb.append(p);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String removeOuterParenthesesOld(String S) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (char p : S.toCharArray()) {
            if (c == 0) {
                c++;
            } else {
                if (p == '(') {
                    c++;
                    sb.append(p);
                } else {
                    c--;
                    if (c != 0) {
                        sb.append(p);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String removeOuterParenthesesnew(String S) {
        StringBuilder sb = new StringBuilder(S);
        int c = 0;
        int dc = 0;
        for (int i = 0; i < S.length(); i++) {
            if (c == 0) {
                c++;
                sb.deleteCharAt(i-dc);
                dc++;
            } else {
                if (sb.charAt(i-dc) == '(') {
                    c++;
                } else {
                    c--;
                    if (c == 0) {
                        sb.deleteCharAt(i-dc);
                        dc++;
                    }
                }
            }
        }
        return sb.toString();
    }
}
