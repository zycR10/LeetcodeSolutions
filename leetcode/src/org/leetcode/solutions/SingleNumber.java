package org.leetcode.solutions;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * @Author: Zuo Yichen
 * @Date: 2019/7/28 22:41
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i != len; i++)
            ans ^= nums[i];
        return ans;
    }
}
