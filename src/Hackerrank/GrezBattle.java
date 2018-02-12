package Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class GrezBattle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int power = in.nextInt();
		String[] strArray = in.next().split(",");
		int[] pa = new int[strArray.length];
		for(int i = 0; i < strArray.length; i++) {
			pa[i] = Integer.parseInt(strArray[i]);
		}
		Arrays.sort(pa);
		System.out.println(getCount(power, pa));
	
	}

	private static int getCount(int power, int[] pa) {
		int count = 0;
		for (int i : pa) {
			if(power > i){
				count = count + 1;
				power = power + i/2;
			}else{
				break;
			}
		}
		return count;
	}

}
