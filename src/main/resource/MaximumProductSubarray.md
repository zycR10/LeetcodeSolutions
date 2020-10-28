# MaximumProductSubarray

## 题目
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the 
largest product.
给一个正整数数组，找到其中乘积最大的连续子数组（至少包含一个数字）

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
## 思路 
其实这道题唯一的异常情况就是负数，因为涉及负数要进行符号操作了，那么我们就不能只寻找连续最大值，连续最小值也是需要的，因为当碰到负数的时候
连续最小乘积就变成了最大的，那么就利用min和max记录最小和最大连续乘积，当遇到负数元素时就互换最大最小值，每次min和max去做乘积比较的时候，
要么是min/max * nums\[i\]，要么就是nums\[i\]本身


## 实现 
```
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
```