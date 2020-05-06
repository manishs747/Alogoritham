package arrays;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;*/

//import for Scanner and other utility  classes
import java.util.*;


class TestClass {
    
    
        public static final String  THREE = "Fizz";
        public static final String  FIVE = "Buzz";
        public static final String  THREE_FIVE = "FizzBuzz";
        
        
         public static void print(int num) {
             for (int i = 1; i <= num; i++) {
                 System.out.println(getString(i));
              }
        }
        
        
        public static String getString(int num){
            if((num % 3 == 0) && (num % 5 != 0)){
                return THREE;
            }
             if((num % 3 != 0) && (num % 5 == 0)){
                return FIVE;
            }
            if((num % 3 == 0) && (num % 5 == 0)){
                  return THREE_FIVE;
             }
             return num+"";
        } 
    
    
    
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        
        

        for (int i = 0; i < N; i++) {
           int num = s.nextInt();
           print(num);
        }
    }
}
