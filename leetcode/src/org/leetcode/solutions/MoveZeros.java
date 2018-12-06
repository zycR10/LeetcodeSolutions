package org.leetcode.solutions;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
		int index = 0;
		if (nums != null && nums.length != 0) {
			for (int num : nums) {
				if (num != 0) {
					nums[index++] = num;
				}
			}
			for (; index < nums.length; index++) {
				nums[index] = 0;
			}
		}
	}

	public void moveZeros(int[] nums) {
		int index = 0;
		int temp;
		if (nums != null && nums.length != 0) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					temp = nums[i];
					nums[index++] = temp;
					nums[i] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		new MoveZeros().moveZeroes(nums);
	}
}
