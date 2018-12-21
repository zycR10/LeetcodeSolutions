package org.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Zuo Yichen
 * @Date: 2018/12/21 14:36
 */
public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        if (index == nums.length - 1) {
            list.add(nums[index]);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        int temp = nums[index];
        for (int i = index; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            // add nums[i] to list
            // swap i and index element, means modify element order in array nums.
            if (i != index) {
                nums[index] = nums[i];
                nums[i] = temp;
            }
            // keep looking for next index, elements order have been rescheduled.
            backTrack(nums, index + 1, res, list);
            // revert the order
            if (i != index) {
                nums[i] = nums[index];
                nums[index] = temp;
            }
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(new PermutationII().permuteUnique(nums));
    }
}
