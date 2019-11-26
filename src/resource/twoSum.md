# LeetCode第一题

## 题目
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
给定整型数组和目标值，返回数组中和为该目标值的数字的数组下标，
You may assume that each input would have exactly one solution, and you may not use the same element twice.
可以假定对于每种输入只有一个正确答案，并且数组中同一个元素不会被使用两次
例如：
nums = [2, 7, 11, 15], target = 9,
nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

## 实现思路
实现起来比较简单，只需要添加定义一个map作为存储，key = i (0 <= i < nums.length), value = nums[i], 遍历数组nums，对当前数字n，
在map中查找 target - n是否存在，如果存在则证明和为target值的两个元素已经找到，直接返回元素数组下标即可，
如果不存在则将当前数组下标和元素值put到map中，算法复杂度O(n)

## 代码实现
```$xslt
public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(res.containsKey(target - nums[i])){
                result[0] = res.get(target - nums[i]);
                result[1] = i;
                break;
            }
            res.put(nums[i],i);
        }
        return result;
    }
```