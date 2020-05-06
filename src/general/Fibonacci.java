package general;

public class Fibonacci {
	
	static int n1 = 0;
	static int n2 = 1;
	static int n3;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printFibRec(10);
	}

	
	public static void printFib(int n){
		int a = 0;
		int b =1;
		for (int i = 0; i < n; i++) {
			System.out.print(a+" ");
			int temp = a+b;
			a=b;
			b=temp;
		}
	}
	
	
	public static void printFibRec(int n){
		
		if(n>0){
			System.out.print(n1+" ");
			 n3 = n1+n2;
			n1=n2;
			n2=n3;
			printFibRec(n-1);
		}
		
			
		
	}

}
