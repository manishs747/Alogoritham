package algorithams.greedy;

import java.util.Arrays;

public class AssignCookie {

    public static void main(String[] args) {
      int []  g = {1,2} , s = {1,2,3};
       // greeds = [1, 3, 3, 4]
       // cookies = [2, 2, 3, 4]
        System.out.println(findContentChildren(g,s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gd = 0 , c = 0 , count = 0;
        while (gd < g.length && c < s.length){
            if (g[gd] <= s[c]){
                count++;
                gd++;
            }
            c++;
        }
        return count;
    }

}
