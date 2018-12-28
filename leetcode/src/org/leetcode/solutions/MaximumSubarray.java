package org.leetcode.solutions;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/28 17:56
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //dp[i] means the maximum subarray ending with A[i];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            // divide the problem into sub problem
            // the max subarray max can think as [0,i], 0 is not mean real 0, but the max array start
            // if you want to find the maxarray, at least you should start at a positive element
            // and whether the sum before this positive element is needed ,it depends on whether the sum is positive
            // negative sum is obviously no need to add to a positive element, you can start from this element as a new start.
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
