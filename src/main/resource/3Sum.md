# 3 sum

## 题目
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.
给定一个由整数组成的数组nums，找出所有三个元素相加等于0的组合
例如：
nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

## 实现思路
首先可能会想到类似于两个数求和的拓展，可以先算出两个数的和，然后去找第三个符合的数，但这样相当于遍历操作。其实稍加变化就可以了，我们不要在原数组上进行这样的求和操作，因为那样既相当于是遍历搜索，另外还有可能有重复的答案，我们还需要额外的工作去记录特殊情况，如果能够在求和之前，先将数组排好序，然后选定第一个元素作为key，然后取后面第一个元素为左边界，数组最后一个数字为右边界，如果此时key与两个边界的值相加等于零，那么就把三个元素放入结果集中，如果小于0，那么我们只需要移动左边界，反之移动右边界，并且通过简单判断可以快速跳过一样的元素。算法复杂度O(n2)。

## 代码实现
```
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
}
```

