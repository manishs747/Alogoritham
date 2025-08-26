package data_structure.strings.online;


/*
https://leetcode.com/problems/adding-spaces-to-a-string/description/?envType=daily-question&envId=2024-12-03
 */
public class AddSpaceString {

    public static void main(String[] args) {
        System.out.println(addSpaces("EnjoyYourCoffee",new int []{5,9}));
    }


    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int lastIndex = 0;
        for (int i = 0; i < spaces.length; i++) {
           sb.append(s,lastIndex,spaces[i]).append(" ");
            lastIndex = spaces[i];
        }
        sb.append(s,lastIndex,s.length());
        return sb.toString();
    }
}
