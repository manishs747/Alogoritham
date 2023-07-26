package data_structure.strings.online;

public class RemoveStars {


    public static void main(String[] args) {
        String  s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String str) {
        StringBuilder sb = new StringBuilder();
        for (int s = 0; s < str.length() ; s++)
            if(str.charAt(s) == '*')
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(str.charAt(s));
        return sb.toString();
    }

}
