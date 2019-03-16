package org.leetcode.solutions;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
                continue;
            }
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }
        return count > nums.length / 2 ? candidate : 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
}
