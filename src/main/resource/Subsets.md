# Subsets

## 题目
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
给一个不重复的整数集合，返回所有可能的子集合

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 
## 思路 
典型回溯算法，实在懒得介绍了。。。甚至比其他回溯更简单，因为不用判断最后的终止条件。。

## 实现 
```
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        res.add(new ArrayList(curr));
        backTrack(res, curr, nums, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            res.add(new ArrayList(curr));
            backTrack(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
```