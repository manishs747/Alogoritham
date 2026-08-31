package advaith;

public class Array {

    public static void main(String[] args) {
<<<<<<< HEAD
        int [] arr = {2,1,8,6,4};
        int max = arr[0];
        for (int i = 0; i < 5 ; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
=======
        int [] arr = {2,3,5,6,7};

        for (int i = 0; i < 5 ; i++) {
            System.out.println("i = "+ i+" :"+ arr[i]);
>>>>>>> 5ba0093e6e7247a23c48ff77f00c16f1294e0a74
        }
        System.out.print(max);

    }
}
