package regex;


/*
https://www.geeksforgeeks.org/remove-leading-zeros-from-a-number-given-as-a-string/#:~:text=Use%20the%20inbuilt%20replaceAll(),value%20with%20the%20given%20string.
 */
public class RemoveLeadingZero {

    public static void main(String[] args) {

       String str = "000560000";

        // Regex to remove leading
        // zeros from a string
        String regex = "^0+(?!$)";

        // Replaces the matched
        // value with given string
        str = str.replaceAll(regex, "");

        System.out.println(str);
    }

}
