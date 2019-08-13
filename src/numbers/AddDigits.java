package numbers;

public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(38));
	}


	public static  int addDigits(int num) {
		while(num > 9) {
			int tmp = num;
			int sum = 0;
			while(tmp != 0) {
				sum += tmp%10;
				tmp = tmp/10;
			}
			System.out.println("SUM:"+sum);
			num = sum;
		}
		return num;
	}

}
