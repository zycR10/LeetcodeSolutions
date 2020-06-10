# Find First and Last Position of Element in Sorted Array

## 题目
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
给定一个正序排列的整型数组，找到目标元素的起始和终止位置
Your algorithm's runtime complexity must be in the order of O(log n).
算法复杂度要求为O(log n)
If the target is not found in the array, return [-1, -1].
如果在数组中没有找到目标元素，返回[-1, -1]

例子1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
例子2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

## 实现思路
题干中已经算给了很大的提示，在数组中查找特定的目标值，且复杂度O(log n)，那么显然是二分法，二分法拆分为三次做，第一次通过二分法第一次找到目标值target所在位置，然后针对所在位置左右两侧的数组元素再次进行二分法搜索，数组左侧的二分法改动是在找到目标值后继续查询左侧数组，直到找到最左侧位置的目标值，右侧同理，唯一的变化就是找到目标之后继续向右查询

## 代码实现
```
public class FindFirstAndLastPositionOfElementinSortedArray {
    // the algorithm requires O(logn)
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (high - low) / 2 + low;
        int[] res = {-1, -1};
        // use binary research to find mid
        // nums[mid] = target
        while (low <= high && nums[mid] != target) {
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
            // don't forget this
            // for myself, I always forget this line, cause dead loop
            mid = (high - low) / 2 + low;
        }
        if (mid < nums.length && nums[mid] == target) {
            res[0] = findFirstPosition(nums, low, mid, target);
            res[1] = findLastPosition(nums, mid, high, target);
        }
        return res;
    }

    private int findLastPosition(int[] nums, int low, int high, int target) {
        int mid = (high - low) / 2 + low;
        int right = low;
        while (low <= high) {
            if (nums[mid] == target) {
                right = mid;
                // maybe this is not the last one, continue find next
                low = mid + 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
            mid = (high - low) / 2 + low;
        }
        return right;
    }

    private int findFirstPosition(int[] nums, int low, int high, int target) {
        int mid = (high - low) / 2 + low;
        int left = high;
        while (low <= high) {
            if (nums[mid] == target) {
                left = mid;
                // maybe this is not the first, continue find previous one
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
            mid = (high - low) / 2 + low;
        }
        return left;
    }
```