package org.leetcode.solutions;

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
		if(isExist) {
			// TODO
		}
	}
}
