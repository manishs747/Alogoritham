import java.util.ArrayList;
import java.util.Scanner;


public class bank {

	public static void main(String[] args) {
		 Scanner  in = new Scanner(System.in);
		 int n = in.nextInt();
		 
		 ArrayList<Integer>  list = new ArrayList<Integer>();
		 for (int i = 0; i < n; i++) {
			 list.add(in.nextInt());
		}
     System.out.println("list is "+list);

	}

}
