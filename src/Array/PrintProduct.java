package Array;

public class PrintProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,2,3,4};
		arr = productExceptSelf(arr);
		Utility.print(arr);

	}
	
	
	
	public  static int[] productExceptSelf(int[] nums) {
		int  [] result = new int[nums.length];
		int mul = 1;
		int zeroCount = 0;
		for (int num : nums) {
			if(num == 0 && zeroCount == 0) {
				zeroCount++;
				continue;
			}
			mul *=  num;
		}
		System.out.println("Zero Count"+zeroCount);
		for (int i = 0; i < result.length; i++) {
			if(nums[i] != 0) {
				if (zeroCount > 0) {
					result[i] =0;
				}
				if(zeroCount > 0) {
					result[i] = 0;
				}else {
					result[i] = mul/nums[i]; 
				}
			}else {
				if(zeroCount == 1) {
					result[i] = mul;
				}
			}
		}
		return result ;
	}

}
