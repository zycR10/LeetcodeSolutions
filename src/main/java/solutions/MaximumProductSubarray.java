package solutions;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6O
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @Author: Zuo Yichen
 * @Date: 2019/11/17 18:18
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int res = nums[0];
        int currMax = res;
        int currMin = res;
        int temp;
        // record max and min
        for (int i = 1; i < nums.length; i++) {
            // negative, max * (-n) = min, and min * (-n) become max, so just swap them
            if (nums[i] < 0) {
                temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            // positive, just go on
            // zero, currMax restore the res before zero and currMax change to 0 ready for next
            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);
            res = Math.max(res, currMax);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }
}
