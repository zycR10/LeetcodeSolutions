# SingleNumber

## 题目
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
给一个非空的正整数数组，除了一个元素之外，剩下的所有元素都出现了两次，找到这个唯一的元素。
算法要求时间复杂度为线性，即O(n)且不使用多余内存

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
 
## 思路 
题本身肯定是不难的，如果实现的话也有很多种方式，但是题目中明确要求了时间复杂度为O(n)且不适用额外的内存，也就是说我们首先要一次遍历就搞定这个
问题，其次不能够使用其他数据结构作为辅助，反正我是因为提前知道了解法，所以写出来很简单，但是如果不了解的话确实可能想不到，真正实现代码可能
只需要三行就够，这个神技就是：位运算。位运算可能平时工作用不到，写算法的时候也不算很常见的思路，所以想不到很正常，位运算中的异或是一个正好解决
这个问题的操作，异或的大致概念是如果不相同，则为1，相同则为0，即异为1，同为0，那我们再反过来想，0异或1得1，0异或0得0，所以说0异或任何数仍
得其本身，那么由于题目中所以其他数字都是两个，所以两个相同数字异或得0，所以数组中除了唯一数字以外，其他所有元素做异或最后的结果为0，而0与任何
数字异或仍得其本身，所以遍历数组，对每一个元素做异或，最后的结果就是答案，相当于异或是一个过滤器，将所有成对出现的元素全部过滤了

## 实现 
```
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
```