# TwoSumIIArraySorted

## 题目
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a 
specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must 
be less than index2.
给定一个已经按升序排列的整数数组，找出数组中的两个元素，使其相加的和为给的目标数字
要求返回这两个数字的位置下标，位置一必须小于位置二

Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
注意：
返回值的下标从一开始计算，可以假定题目只有唯一解且同一个元素不能使用两次。 

>Example 1: 

>Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

>Example 2:

>Input: numbers = [2,3,4], target = 6
Output: [1,3]

>Example 3:

>Input: numbers = [-1,0], target = -1
Output: [1,2]
 
## 思路 
由于数组已排好序，所以我们可以设置两个下标，一个在头部一个在尾部，计算当前和，如果和大于目标值，说明需要缩小当前和，那么就把尾部下标向左移，
否则就头部下标右移，直至找到结果

## 实现 
```
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int curr = numbers[left] + numbers[right];
            if (curr == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (curr < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return res;
    }
```
