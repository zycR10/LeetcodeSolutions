# FirstMissingPositive

## 题目 
Given an unsorted integer array, find the smallest missing positive integer.
给一个未排序的整数数组，寻找缺失的最小正整数

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

## 思路 
方法一：
利用set，遍历数组将元素放入set中，再从1开始遍历正整数，如果可以放入set，说明该数字不存在于数组中且为当前缺失的最小正整数

## 实现 
```
方法一：
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (set.add(i)) {
                return i;
            }
        }
        return set.size() + 1;
    }

```
