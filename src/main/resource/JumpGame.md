# JumpGame

## 题目
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
给一个正整数数组，数据组中的每个元素代表了在当前位置的最远跳跃距离，假设起点在数组第一位，判断能否到达最后一位 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 
## 思路 
一道标准的贪心算法，要判断是否能够到达数组的最后一位，数组中每一个元素能跳的最远距离是nums[i] + i，所以对数组遍历，如果这个值大于等于数组长度，即可以到达最后一位，
那如果无法达到的特殊情况是什么呢？比如前面能跳的最远距离为d，但是循环下标i>d，说明还尚未到达数组末位的时候，最远距离d已经无法到达当前位置了。

## 实现 
```
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(i + nums[i], max);
            if (max >= length - 1) {
                return true;
            }
        }
        return true;
    }
```