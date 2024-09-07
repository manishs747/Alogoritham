package data_structure.strings.online;

public class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        String s = "0101";
        System.out.println(maximumOddBinaryNumber(s));
    }


    public static String maximumOddBinaryNumber(String s) {
         int count = 0;
        for (char c :s.toCharArray()) {
            if(c == '1'){
                count++;
            }
        }
        char [] chararr = s.toCharArray();
        chararr[s.length()-1] = '1';
        int c = 0;
        while (count > 1){
            chararr[c++] = '1';
            count--;
        }
        while (c < s.length()-1){
            chararr[c++] = '0';
        }
        return new String(chararr);
    }
}
