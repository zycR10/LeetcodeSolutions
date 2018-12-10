package org.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/10 13:09
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        // deep first search.
        dfs(0, res,candidates, new ArrayList<>(), 0, target);
        return res;
    }

    private int dfs(int sum, List<List<Integer>> res,int[] candidates, List<Integer> currList, int start, int target) {
        if (sum > target) {
            return 1;
        }
        if (sum == target) {
            // must a new list or the reference can be changed and effect on result
            res.add(new ArrayList<>(currList));
            return 1;
        }else {
            for (int i = start; i < candidates.length; i++) {
                // for example {10, 1, 2, 7, 6, 1, 5}
                // you got double 1, so if you don't check this, you will get double result start with 1
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                currList.add(candidates[i]);
                int sumResult = dfs(sum + candidates[i], res, candidates, currList, i + 1, target);
                currList.remove(currList.size() - 1);
                if (sumResult != -1) {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        new CombinationSumII().combinationSum2(candidates, 8);
    }
}
