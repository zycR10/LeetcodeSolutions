# MajorityElement

## 题目
Given an array of size n, find the majority element. The majority element is the element that appears more than  \[n/2\] ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
给定一个长度为n的数组，找出其中的众数。众数是指该元素重复出现次数超过n/2次
可以假设数组不为空且必存在一个众数

*Example 1*:

>Input: [3,2,3]  
Output: 3

*Example 2*:

>Input: [2,2,1,1,1,2,2]  
Output: 2
 
## 思路 
这道题还是很简单的，有两种思路。第一种，因为众数个数大于n/2次，所以假如我们把数组排序，那么最后在中间位置的数字一定是该数字，因为大于n/2嘛，
所以排序后一定是前半段或者后半段或者中间段都是这个数字，无论在哪一段里，都会覆盖到中间位置，代码也很简单，愿意自己写排序就自己写，否则就是
Arrays.sort()。第二种算法就比较巧妙了，是一种叫做摩尔投票算法的理论，大体来讲是这样，假如说我和别人打仗，我的兵和对面的兵一样的战斗力，
1v1的话结果就是同归于尽，那么最后一定是人多的一方获得胜利，这道题中类似的用这种消耗的方式去找，记录一个candidate值为当前元素，count为计数
器，如果当前元素和candidate相同，count加一，不同则减一，当count为0时则使当前元素成为candidate，在这种情况下拥有超过n/2数量的值一定会
保留到最后，因为就算最差的情况数组里众数和其他元素是交叉排列的，每个众数都会被其他元素消耗，但由于总体大于n/2，所以最后剩下的一定是众数，
如果数组中元素互相之间还会消耗，那最后剩下的也一定是众数。就好比和别人打仗，大家轮流过来打你，但是你比所有人加起来都厉害，那你稳赢，如果他们
之间再互相打打，那你赢得就更轻松了

## 实现 
```
方法一：
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
方法二:
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate) ? 1 : -1;
        }
        return candidate;
    }

```
