package data_structure.arrays;

import java.util.HashSet;
import java.util.Set;

public class test {
	
/*
	4
	1 2 3 4
	12 13 14 5
	11 16 15 6
	10 9 8 7
	
	
8
1 2 3 4 5 6 7 8
28  29  30  31  32  33  34  9
27  48  49  50  51  52  35  10
26  47  60  61  62  53  36  11
25  46  59  64  63  54  37  12
24  45  58  57  56  55  38  13
23  44  43  42  41  40  39  14
22  21  20  19  18  17  16  15
	
	*/
	
	
public static void main(String[] args) {

	System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));


	
}


	public static boolean checkIfPangram(String sentence) {
    if(null == sentence || sentence.length() < 26){
    	return false;
	}
        Set<Integer> set = new HashSet<>();
		for (int i =0;i<26;i++) {
			set.add(97+i);
		}
		System.out.println(set);
		for (char c : sentence.toCharArray()) {
			int a = c;
			set.remove(a);
		}
	   return set.isEmpty();
	}





private static void spiralPrint( int[][] arr) {
	int R = arr.length;
    int C = arr[0].length;
    int  r = 0, c = 0;//starting row and column
    while(r<R && c< C){
    	for (int i = c; i < C-c; i++) {
			System.out.print(arr[r][i]+" ");
		}
    	r++;
    	for (int i = r; i <= R-r; i++) {
    		System.out.print(arr[i][C-c-1]+" ");
		}
    	c++;
    	for (int i = C-c-1; i >= c-1; i--) {
    		System.out.print(arr[R-r][i]+" ");
		}
    	for (int i = R-r-1; i > r-1; i--) {
    		System.out.print(arr[i][c-1]+" ");
		}
    }
}

public static void spiralPrint(int R,int C,int arr[][]){
	int  r = 0, c = 0;//starting row and column

	while(r<R && c< C){

		for (int j = c; j < C ; j++) {
			System.out.print(arr[r][j] +" ");
		}
		r++;

		for (int j = r;j <R; j++) {
			System.out.print(arr[j][C-1]+" ");
		}
		C--;

		for (int j = C-1; j >= c; j--) {
			System.out.print(arr[R-1][j]+" ");
		}
		R--;

		for (int j = R-1; j >= r; j--) {
			System.out.print(arr[j][c]+" ");
		}
		c++;
	}
}
}


