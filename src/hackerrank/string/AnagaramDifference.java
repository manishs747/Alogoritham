package hackerrank.string;

import java.util.Scanner;

import Array.Utility;


/*
 * /*
10
hhpddlnnsjfoyxpci
xulkowreuowzxgnhmiqekxhz
dnqaurlp
aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqra
lbafwuoawkxydlfcbjjtxpzpchzrvbtiev
drngbjuuhmwqwxrinxccsqxkp
ubu
vxxzsqjqsnibgydzlyynqcrayvw
xtnipeqhxvafqaggqoanvwk
gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvz
10
ioigvjqzfbpllssuj
istdocbnyozmnqthhpievvlj
lofnrtmh
sqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb
qbpedlqbktorypcjkzzkodrpvosqzxmpad
wygwcdbtriwaesjsobrntzaqbe
lzt
jurfsqfrivayopgrxewwruvemzy
mthtfirwhmjrbphlmeluvoa
nspiwquxxsiwuldizqkkaawpyyisnftdzklwagv

 */

/*
 * 
 * 
 * 10
 * 13
 * 5
 * 26
 * 15
 * -1
 * 3
 * 13
 * 13
 * -1
 * 
 * 
 * 
 * 
 3
aa
ab
cd
3
ba
ba
ef
 * 
 */
 

public class AnagaramDifference {

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String [] a  = getInputArray(in, n);
		System.out.println("First ARRAy");
		Utility.printString(a);
		n = in.nextInt();
		String [] b =getInputArray(in, n);
		System.out.println("Second ARRAy");
		Utility.printString(b);
		
	}

	private static String [] getInputArray(Scanner in, int n) {
		String [] a = new String[n];
		for(int i=0;i<n;i++){
			String str = in.next();
            a[i] = str;
		}
		return a;
	}

}
