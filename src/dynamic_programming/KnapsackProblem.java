package dynamic_programming;

/*
 * https://www.geeksforgeeks.org/knapsack-problem/
 * 
 * https://www.youtube.com/watch?v=qOUsP4eoYls
 * 
 * https://www.youtube.com/watch?v=PLJHuErj-Tw&list=PLW1OMpQZxu7z9d3aajQ0EerthCGaE3QLS&index=9
 * 
 * 
 * 
 * 
 */

public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static class MaxiumSubArray {

        public static int getMax(int a[]){
              int max_so_far = a[0];
               int curr_max = a[0];
               for (int i = 1; i < a.length; i++)
               {
                    curr_max = Math.max(a[i], curr_max+a[i]);
                    max_so_far = Math.max(max_so_far, curr_max);
               }
               return max_so_far;
        }



        public static int getNoncontMaxSubarray(int a[]){
            int sum = 0;
             for (int i = 0; i < a.length; i++)
               {
                    if(a[i]>0){
                        sum+=a[i];
                    }
               }
             return sum;
        }


        public static void main(String[] args) {
            int a[] = {-2,-11,-4,-13,-5,-2};
            int b[] = {1,-3,4,-2,-1,6};


            System.out.println(getMax(b));
            System.out.println(getNoncontMaxSubarray(b));
        }
    }
}
