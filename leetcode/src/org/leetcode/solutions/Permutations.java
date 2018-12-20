package org.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/20 10:04
 */
public class Permutations {
    //Solution 1：
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        if (index == nums.length - 1) {
            list.add(nums[index]);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        int temp = nums[index];
        for (int i = index; i < nums.length; i++) {
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

    // Soluton 2:
    // arrays don't have duplicate element, so no need to change elements order in loop
    // just loop and skip when list.contains(nums[i])
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permutations().permute(nums));
    }
}
