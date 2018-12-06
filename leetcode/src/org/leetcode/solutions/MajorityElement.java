package org.leetcode.solutions;

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
		int[] nums = { 3, 2, 3 };
		System.out.println(new MajorityElement().majorityElement(nums));
	}
}
