package org.leetcode.solutions;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		boolean isExist = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				isExist = true;
				break;
			}
		}
		if (isExist) {
			generateNextPermutation(nums);
		} else {
			reverseArrays(nums);
		}
	}

	private void reverseArrays(int[] nums) {
		// TODO Auto-generated method stub

	}

	private void generateNextPermutation(int[] nums) {
		// TODO Auto-generated method stub
		int max = -1;
		for (int i = nums.length - 1; i > 0; i++) {
			if (nums[i] < max) {
				Arrays.sort(nums, i + 1, nums.length - 1);
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
	}
}
