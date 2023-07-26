package data_structure.general;

public class Maximum69Number {

    public static void main(String[] args) {

    }

    public static int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        for (int i = 0;i < sb.length();i++) {
            if(sb.charAt(i) == '6'){
                sb.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
