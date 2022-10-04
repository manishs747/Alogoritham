package data_structure.strings.online;


/**
 * https://leetcode.com/problems/rings-and-rods/
 */
public class RingsAndRods {

    public static void main(String[] args) {
          String rings = "B0B6G0R6R0R6G9";
        System.out.println(countPoints(rings));
    }

    public static int countPoints(String rings) {
      int [] red = new int[10] , blue = new int[10] , green = new int[10];
        for (int i = 0; i < rings.length(); i = i+2) {
            int post = Character.getNumericValue(rings.charAt(i+1));
            char color = rings.charAt(i);
            if(color == 'R')
                red[post] = 1;
             else if (color == 'B')
                blue[post] = 1;
            else
                green[post] = 1;
        }
        int count = 0;
        for(int i = 0;i < 10 ;i++){
            if( red[i] == 1 && blue[i] == 1 & green[i] == 1)count++;
        }
        return count;
    }
}
