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
其实题目给了很明显的提示，在一个类似于有序数组中找到一个数字且时间复杂度为O(log n)的算法，很容易想到的就是二分法,
这道题其实就是二分法的一个变种，大概使用二分法的思路即可。首先每次循环也是取中间值，但是由于当前数组不是连续有序的，
所以不能简单地判断array[mid]和target的值区分下一步的移动方向，问题的关键在于确定target在左右哪个半区即可，
数组虽然旋转过，但是不过从哪个数字切开分为左右两个部分，至少其中有一个部分是连续有序的，通过比较连续有序的左右边界值是否包含了target值，即可确定在target在左右哪个部分中。所以问题变成了如何判断左右哪个部分是连续有序的，很简单，比较左端点和中间值的元素大小即可，如果左端点小于中间值，说明左侧一定是连续有序的，否则就是右侧。找到target值所在的一侧后移动left或者right值然后重复上述步骤即可

## 代码实现
```aidl
private int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // such as nums = {4,5,6,7,8,0,1,2,3}, you can think first array is {4,5,6,7,8}
            // and second array is {0,1,2,3}
            // check if nums[mid] and target split into different arrays
            boolean split = (nums[mid] >= nums[0]) != (target >= nums[0]);
            if (split) {
                if (target >= nums[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
    }
```