package solutions;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		generateNextPermutation(nums);
	}

	private void generateNextPermutation(int[] nums) {
		int max = -1;
		for (int i = nums.length - 1; i >= 0; i--) {
			// if nums order by desc, it doesn't has next permutation
			if (nums[i] < max) {
				int ex = -1;
				for (int j = i + 1; j < nums.length; j++) {
					// find the smallest number of the numbers greater than
					// nums[i]
					if (nums[j] > nums[i]) {
						ex = j;
						continue;
					}
					break;
				}
				if (ex != -1) {
					// exchange i and j
					// int temp = nums[i];
					// nums[i] = nums[ex];
					// nums[ex] = temp;
					swap(nums, i, ex);

					// smallest number means order by ascending
					Arrays.sort(nums, i + 1, nums.length);
					return;
				}
			}
			max = nums[i];
		}
		
		// replace sort by reverse, more efficient.
		// Arrays.sort(nums);
		reverse(nums);
	}

	private void reverse(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String arg[]) {
		int[] nums = { 1, 3, 2 };
		new NextPermutation().nextPermutation(nums);
		System.out.println(nums);
	}
}
