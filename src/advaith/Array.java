package advaith;

public class Array {

    public static void main(String[] args) {
        int [] arr = {2,1,8,6,4};
        int max = arr[0];
        for (int i = 0; i < 5 ; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.print(max);

    }
}
