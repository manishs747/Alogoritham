import java.util.Arrays;

public class Test {

	public enum EntityType {
		USER, GROUP, ROLE, APPLICATION, SCOPE, RESOURCE, PERMISSION, UNSPECIFIED,FINELINE_CATEGORY_MAPPING,CATEGORY_BUYER_MAPPING,
		BRC_BUYER_MAPPING,BUYER_BRC_MAPPING,ACTION
	}

	public static void main(String[] args) {
		int[] s1 ={4,1,8,10}; // -> 3   ||3
		int[] s2 ={7,8,8};  //5     1
		int[] s3 ={3,4,7,0};   // 5    7
		System.out.println(smallestRangeII(s3,5));//7
	}


	public static int smallestRangeII(int[] A, int K) {
		Arrays.sort(A);
		int len = A.length;
		int ans = A[len-1] - A[0];
		for (int i = 0; i < A.length - 1; ++i) {
			int a = A[i], b = A[i+1];
			int high = Math.max(A[len-1] - K, a + K);
			int low = Math.min(A[0] + K, b - K);
			ans = Math.min(ans, high - low);
		}
		return ans;
	}


}
