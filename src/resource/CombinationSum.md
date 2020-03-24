# Combination Sum

## 题目
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
给定一个没有重复数字的候选数组和一个目标值，找出数组中数字之和为目标值的组合
The same repeated number may be chosen from candidates unlimited number of times.
同一个数字被选择的次数没有限制
Note:
注意：
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
所有数字均为正整数，答案中不包含重复的组合

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

## 思路
分析题目后认定题目属于给定目标值，在数组中寻找和为目标值的元素组合，题目需要注意的点是数组中的元素是可以重复使用的，也就是说比如目标值是8，数组中有2，那么返回值中要有{2,2,2,2}，根据这个条件的话可以确定首先肯定是要多次遍历了，没有其他简单算法，但是肯定也不是暴力搜索，否则复杂度就是O(n2)了，这种题目的小技巧都是先给数组排序，排序后我们就有规律可循，也方便提前退出循环。具体思路是这样，先将给定数组排序，然后对数组采用回溯的算法，简单解释回溯算法就是一直往下走，走不通了再回退一步，换条路走，针对这道题就是一直用第一个数加，直到总和为目标值时放入结果集，或者总和已经大于了目标值，由于数组是已排序的，再向下查找也没有意义了，也可以提前退出，退到上一层然后继续往下算

## 代码
```
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0, candidates, new ArrayList<>(), res, target, 0);
        return res;
    }

    private int backTrack(int sum, int[] candidates, List<Integer> currList, List<List<Integer>> res, int target, int start) {
        if (sum > target) {
            return 1;
        }
        if (sum == target) {
            res.add(new ArrayList<>(currList));
            return 0;
        }else {
            for (int i = start; i < candidates.length; i++) {
                currList.add(candidates[i]);
                int sumResult = backTrack(sum + candidates[i], candidates, currList, res, target, i);
                currList.remove(currList.size() - 1);
                // arrays has been sorted, if sum > target or sum = target
                // means it's obviously sum + next element > target, so we can break the loop here.
                if (sumResult != -1) {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] candidates = {2,2,6,7};
        new CombinationSum().combinationSum(candidates, 8);
    }
}
```