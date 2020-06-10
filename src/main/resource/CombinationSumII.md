# Combination II

## 题目
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
给定一个数组和一个目标值，在数组中找出所有合为目标值的组合
Each number in candidates may only be used once in the combination.
数组中的每个元素只能用一次
Note:
注意
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
所有数字都是正整数且结果中不包含重复组合

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

## 思路
和[上一题](https://github.com/zycR10/LeetcodeSolutions/blob/master/src/resource/CombinationSum.md)十分相似，如果上一道题的回溯算法你了解了，那么这道题你会发现其实完全相同的处理方式就可以了是不是？只需要在回溯过程中调整一下数组下标，之前由于单个元素可以重复使用，所以每轮循环都是从数组第一个元素开始算起，但是这道题要求同一元素只能使用一次，所以我们只要每次在传入start位置的时候+1就可以了，但是这里有一个小陷阱，上一道题中数组中没有重复元素，而这道题中是可以有重复元素的，由于每个元素只能使用一次，所以在循环中注意这个判断就可以了

## 代码
```
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
```