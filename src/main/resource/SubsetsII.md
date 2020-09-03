# SubsetsII

## 题目
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
给一个可能存在重复整数的集合，返回所有可能的子集合
注意：子集合中的结果不要重复

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 
## 思路 
和上一道[Subsets](https://github.com/zycR10/LeetcodeSolutions/blob/master/src/main/resource/Subsets.md)几乎一样，但是唯一的不同是这次数组中可能存在重复的数了，
所以代码和上一道几乎类似，只需要关注如何判断重复就可以了，还是很简单，直接上代码

## 实现 
```
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList();
        backTrack(res, curr, 0, nums);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> curr, int start, int[] nums) {
        res.add(new ArrayList(curr));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            backTrack(res, curr, i + 1, nums);
            curr.remove(curr.size() - 1);
        }
    }
```