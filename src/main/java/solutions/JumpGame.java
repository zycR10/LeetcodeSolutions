package solutions;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 * @Author: Zuo Yichen
 * @Date: 2019/1/2 10:02
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max_reach = 0;
        // from first index calculate max reach index
        // if i larger than max, means the last index is inaccessible
        // if i smaller than max, means i must can be reached, so compare current i + nums[i] and max
        for (int i = 0; i < len - 1; i++) {
            if (i > max_reach) {
                break;
            }
            max_reach = Math.max(max_reach, i + nums[i]);
        }
        return max_reach >= len - 1;
    }

}
