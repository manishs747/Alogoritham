package bitwise;

/*
https://www.geeksforgeeks.org/maximum-xor-of-two-numbers-in-an-array/
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3462/
 */
public class MaximumXOR {


    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};

//"  this   is  a sentence " 9 4
       String text = "  a";
        System.out.println(reorderSpaces(text));

    }

    public static String reorderSpaces(String text) {

        int spaces = 0;
        for(int i = 0; i < text.length(); i++) {
            spaces += (Character.isWhitespace(text.charAt(i))) ? 1 : 0;
        }
        String words [] =  text.trim().split("\\s+");
        if(words.length < 2){
            return words[0]+getSpace(spaces);
        }

        int space = spaces/ (words.length-1);
        int left =  spaces% (words.length-1);
        StringBuilder result = new StringBuilder();
        for (String word:words) {
            result.append(word);
            result.append(getSpace(space));
        }

        return result.toString().trim()+getSpace(left);
    }

    public static String getSpace(int n){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<n;i++){
            result.append(" ");
        }
        return result.toString();
    }



}
