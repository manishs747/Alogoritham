package algorithams.backtracking;

public class Permutation {

    public static void main(String[] args) {
        String str = "ABC";
        char[] arr = str.toCharArray();
        permute(arr, 0, str.length() - 1);

    }

    static void permute(char[] str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(str, l, i);
            permute(str, l + 1, r);
            swap(str, l, i);
        }
    }


    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
