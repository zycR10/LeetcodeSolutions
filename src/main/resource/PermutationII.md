# PermutationII

## 题目 
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
给一个可能有重复数字的集合，返回所有存在的组合

例：
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

## 思路 
本题和上一道Permutations的区别在于数组中可能存在重复数字，那么也就是需要处理重复数字即可，在遍历之前我们可以先排序，数组有序后假设重复数字是a1,a2，那么如果希望保证最后结果不重复，
也就是只要能够保证a1,a2的顺序一直保持不变，即不要出现最后结果，b,a1,a2和b,a2,a1，所以我们额外维护一个数组用于记录当前位置的元素是否使用过，每次循环之前判断即可

## 实现 
```
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, result, list, used);
        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backTrack(nums, result, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
```
