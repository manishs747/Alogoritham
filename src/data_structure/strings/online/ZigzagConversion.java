package data_structure.strings.online;

public class ZigzagConversion {

    public static void main(String[] args) {
        String str = "AB";
        System.out.println(convert(str,1));
    }


    public static String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int rowIndex = 0;
        boolean goingDown = false;
        for (char c:s.toCharArray()) {
            rows[rowIndex].append(c);
            if (rowIndex == 0 || rowIndex == numRows - 1)
                goingDown = !goingDown;
            rowIndex += goingDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder str : rows) {
             sb.append(str);
        }
        return sb.toString();
    }
}
;