package org.leetcode.solutions;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/11 11:10
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                continue;
            }
            nums2[nums[i] - 1] = nums[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            if(nums2[i] == 0) {
                return i + 1;
            }
        }
        return nums2.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,9};
        System.out.print(new FirstMissingPositive().firstMissingPositive(nums));
    }
}
