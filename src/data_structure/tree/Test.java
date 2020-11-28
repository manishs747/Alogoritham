package data_structure.tree;

public class Test {

	public static void main(String[] args) {

		System.out.println(smallestRepunitDivByK(7));

	
	}

	public static int smallestRepunitDivByK(int K) {
		if (K % 2 == 0 || K % 5 == 0)
			return -1;
		for (int r = 0, n = 1; n <= K; ++n) {
			r = (10 * r + 1) % K;
			if (r == 0)
				return n;
		}
		return -1;
	}
	
	
}
