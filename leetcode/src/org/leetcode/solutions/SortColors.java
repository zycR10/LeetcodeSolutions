package org.leetcode.solutions;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * @Author: Zuo Yichen
 * @Date: 2019/1/30 22:20
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int n0 = 0;
        int n2 = nums.length - 1;
        int i = 0;
        while (i <= n2) {
            if (nums[i] == 0) {
                // i don't need minus one
                // because n0 <= i, former elements have settled, either 0 or 1
                nums[i] = nums[n0];
                nums[n0++] = 0;
            } else if (nums[i] == 2) {
                // i need minus one
                // because n2 >= 0, latter elements are unknown, so let i-- to check
                nums[i--] = nums[n2];
                nums[n2--] = 2;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
    }
}
