# Permutations

## 题目
Given a collection of distinct integers, return all possible permutations.
给一个含有不同整数的数组集合，返回所有的排列组合

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 
## 思路
这种有规律排列出所有的组合的题目最基本的思想就是回溯算法，关键是推导出回溯过程中的关系式即可。先来想一下这道题的解法，如果想要求得所有解，最正确的方式应该是一位一位的确定，
然后再去排列后面的数字，例如总共有n位，先确定第一位，然后再继续排列接下来的n-1位，n-1位的排列方法也是如此，先确定了第一位，然后再继续排列n-2位一次类推，那么什么时候回溯呢？
很简单，当排列至最后一位的时候，说明整个数组排列完了，那么产生了一个结果，记录下来之后即可回溯，回溯到还有最后两位的情况，再次排列完之后继续回溯到还剩最后三位的情况，以此类推。
 
## 实现 
```
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        backTrack(0, nums.length, nums, result);
        return result;
    }

    private void backTrack(int start, int end, int[] nums, List<List<Integer>> result) {
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for (Integer i : nums) {
                list.add(i);
            }
            result.add(list);
        }

        for (int i = start; i < end; i++) {
            swap(nums, start, i);
            backTrack(start + 1, end, nums, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int start, int i) {
        if (start == i) {
            return;
        }

        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
```