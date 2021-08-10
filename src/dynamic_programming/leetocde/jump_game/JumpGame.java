package dynamic_programming.leetocde.jump_game;

public class JumpGame {


    public static void main(String[] args) {
        int [] arr = {2,3,1,1,4};
        System.out.println(canJump(arr));
    }


    /**
     * https://leetcode.com/problems/jump-game/
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
/*********************************************Jump Game II***************************************************/
    /**
     * Jump Game II
     * https://leetcode.com/problems/jump-game-ii/
     * https://www.youtube.com/watch?v=cETfFsSTGJI&t=409s
     *
     *
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
     * then 3 steps to the last index.
     */
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }


/*********************************************Jump Game III ***************************************************/


    /**
     * https://leetcode.com/problems/jump-game-iii/
     * Input: arr = [4,2,3,0,3,1,2], start = 5
     * Output: true
     * Explanation:
     * All possible ways to reach at index 3 with value 0 are:
     * index 5 -> index 4 -> index 1 -> index 3
     * index 5 -> index 6 -> index 4 -> index 1 -> index 3
     */

    public boolean canReach(int[] arr, int start) {


        return false;
    }

/*********************************************Jump Game IV ***************************************************/

    /**
     * Hard
     * https://leetcode.com/problems/jump-game-iv/
     * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
     * Output: 3
     * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
     *
     */

    public int minJumps(int[] arr) {


        return -1;
    }

/*********************************************Jump Game V ***************************************************/


    /**
     *    https://leetcode.com/problems/jump-game-v/
     *    Input: arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
     * Output: 4
     * Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as shown.
     * Note that if you start at index 6 you can only jump to index 7. You cannot jump to index 5 because 13 > 9. You cannot jump to index 4 because index 5 is between index 4 and 6 and 13 > 9.
     * Similarly You cannot jump from index 3 to index 2 or index 1.
      */

    public int maxJumps(int[] arr, int d) {

        return -1;
    }






}



