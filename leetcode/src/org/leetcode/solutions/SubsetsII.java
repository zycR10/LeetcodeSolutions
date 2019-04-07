package org.leetcode.solutions;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2019/4/6 22:00
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // case [4,4,1,4]
        // [4,1] and [1,4] is same result, should not show twice
        Arrays.sort(nums);
//        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        search(0, res, nums, list);
        return res;
    }

    // 2ms
    private void search(int index, List<List<Integer>> res,
                        Set<List<Integer>> set, List<Integer> list,
                        int[] nums) {
        if (index > nums.length - 1) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            if (set.add(list)) {
                res.add(new ArrayList<>(list));
            }
            search(i + 1, res, set, list, nums);
            list.remove(list.size() - 1);
        }
    }

    // 1ms, faster
    private void search (int index, List<List<Integer>> res, int[] nums, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = index; i<nums.length; i++) {
            // not first time search, so i > index
            // nums[i-1] == nums[i], it's duplicate
            if (i > index && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            search(i + 1, res, nums, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        new SubsetsII().subsetsWithDup(nums);
    }
}
