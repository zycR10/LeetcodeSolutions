# Search Insert Position

## 题目
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
给定一个有序数组和一个目标值，返回目标值在数组中的下标，如果没有的话则返回在数组中应插入位置的数组下标
You may assume no duplicates in the array.
你可以假定数组中没有重复元素
Example：

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1


## 思路
题目目标非常清晰，给定数组和目标值寻找下标，属于标准的二分查找算法范围，需要额外处理的就是数组中没有该元素的情况下返回应插入位置的数组下标，
其实观察一下不难发现，查找到最后一个数字的时候，如果该元素大于等于目标值的话，那么目标值插入左边界位置即可，如果该元素小于目标值则需要插入后一位，也就是左边界值+1即可。

## talk is cheap, show me the code
```
public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // make sure not overflow
        int middle = (high - low) / 2 + low;
        while (low < high) {
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            middle = (high - low) / 2 + low;
        }
        if (nums[low] >= target) {
            return low;
        } else {
            return low + 1;
        }
    }
```