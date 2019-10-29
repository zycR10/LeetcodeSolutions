package solutions;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * @Author: Zuo Yichen
 * @Date: 2019/7/31 12:14
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int pre = nums[0], max = 1, currMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre + 1) {
                currMax ++;
            } else if (nums[i] > pre + 1) {
                max = Math.max(max, currMax);
                currMax = 1;
            }
            pre = nums[i];
        }
        return Math.max(max, currMax);
    }
}
