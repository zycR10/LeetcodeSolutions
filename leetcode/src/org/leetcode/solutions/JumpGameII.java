package org.leetcode.solutions;

import sun.applet.Main;

import javax.sound.midi.SysexMessage;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/19 10:45
 */
public class JumpGameII {
    // find from the last one
    // too slow, repeat too many useless step.
//    public int jump(int[] nums) {
//        if(nums.length <= 1) {
//            return 0;
//        }
//        return backTrack(nums, nums.length - 1);
//    }
//
//    private int backTrack(int[] nums, int index) {
//        if (index <= 1) {
//            return index;
//        }
//        int path = 1;
//        int res = Integer.MAX_VALUE;
//        for (int i = index - 1; i >= 0; i--) {
//            if (nums[i] >= path) {
//                res = Math.min(backTrack(nums, i) + 1, res);
//            }
//            path ++;
//        }
//        return res;
//    }

    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            // greedy algorithm
            // find the farthest in this and next step
            curFarthest = Math.max(curFarthest, i + A[i]);
            // curEnd means A[i] can jump to [curStart, curEnd]
            // loop from start to end, find current jump + next jump(A[i])
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,10,1,1,1,1,1,1,1,1,1};
        System.out.println(new JumpGameII().jump(nums));
    }
}
