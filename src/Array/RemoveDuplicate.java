package Array;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {0,0,1,1,1,2,2,3,3,4};
				
		System.out.println(removeDuplicates(nums));
		Array.Utility.print(nums);

	}
	
	
	
	
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 1;
        }
        int prev = nums[0];
        int count = 0;
        for(int i =1;i<nums.length;i++){
            if(prev != nums[i]){
               count++; 
               prev = nums[i];
               swap(nums, count, i);
            }
        }
        return count+1;
    }
    
       public static void swap(int[] nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
