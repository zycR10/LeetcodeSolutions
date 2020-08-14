# MaximumSubarray

## 题目 
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
给一个整数数组，找到连续的子数组（至少包含一个数字），要求子数组的元素之和为最大值，返回该最大值

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

## 思路 
遍历数组，记录两个变量就可以解决这个问题，首先一个变量是currSum，意思是到目前为止的累计和，另一个值就是最后要返回的最大值。currSum值就是遍历过程中
累加当前位置的元素，但是加之前要用累加出来的值和当前位置的元素大小相比，如果当前位置的元素已经大于前面的累加和了，那么就相当于放弃了前面所有的元素，
因为要求最大值，但是当前位置已经超过前面所有元素的和了，所以相当于重新开始算和，从当前位元素为第一位；另一个max值比较好理解，就是每次遍历的时候比较
max和currSum，记录下最大值即可。

## 实现 
```
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i] + currSum, nums[i]);
            max = Math.max(currSum, max);
        }
        return max;
    }
```