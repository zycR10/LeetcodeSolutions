package org.leetcode.solutions;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int high = nums.length - 1;
		int low = 0;
		while (low <= high) {
			int middle = (high - low) / 2 + low;
			if (nums[middle] == target) {
				return middle;
			}
			if (nums[middle] < target) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int target = 0;
		new SearchInsertPosition().searchInsert(nums, target);
	}
}
