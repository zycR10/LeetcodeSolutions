# Search in Rotated Sorted Array

## 题目
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
假设一个倒序排列的数组以某个未知元素为轴旋转
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
例如，[0,1,2,4,5,6,7]变成了[4,5,6,7,0,1,2]
You are given a target value to search. If found in the array return its index, otherwise return -1.
然后会给你一个目标元素在数组中进行搜索，如果存在则返回数组下标，如果不存在则返回-1
You may assume no duplicate exists in the array.
你可以认为数组中没有重复数字
Your algorithm's runtime complexity must be in the order of O(log n).
算法的时间复杂度为O(log n)

## 思路
数组中查找target值，且要求算法复杂度为O(logn),那么很显然是提示需要使用二分法进行查找，这道题作为二分查找的一个变种，唯一的区别在于有序数组可能会以某个元素为轴进行旋转，那么只需要考虑一下这个旋转对二分查找有什么影响就可以了
唯一的影响就是二分查找每次的方向不确定了，因为旋转后数组不再是完全有序，所以不能像正常查找一样target与中间值比较大小然后确定下一步的方向。但是数组虽然不是完全有序，但是仍然是部分有序的，只需要在确定方向的时候对数组进行简单判断，看看当前哪一侧的数组仍然是有序的，然后看看target是否在这段数据中，如果不在，那么只能去找另一侧的数据。再简化点儿说我们比较大小只能对有序的那一侧比较，如果target不在有序那一侧的范围，那么就只能去另一侧找。


## 代码实现
```
private int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
```