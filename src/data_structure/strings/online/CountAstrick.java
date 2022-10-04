package data_structure.strings.online;

public class CountAstrick {

    public static void main(String[] args) {

    }


    public int countAsterisks(String s) {
        int count = 0;
        boolean read = true;
        for (char c : s.toCharArray()) {
            read = (c == '|') ? !read : read;
            count += (c == '*' && read) ? 1 : 0;
        }
        return count;
    }


}
