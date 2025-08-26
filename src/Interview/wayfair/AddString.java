package Interview.wayfair;

public class AddString {

    public static void main(String[] args) {
       String  num1 = "11", num2 = "123";
        System.out.println(addStrings(num1,num2));
    }



    public  static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 && p2 >= 0){
            int num =  num1.charAt(p1) + num2.charAt(p2);

        }
        return res.reverse().toString();
    }
}
