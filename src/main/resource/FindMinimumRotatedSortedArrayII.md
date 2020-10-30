# FindMinimumRotatedSortedArrayII

## 题目
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.The array may contain duplicates.
假定给了一个升序排列的数组，数组以某个点为中心进行了旋转
(例，[0,1,2,4,5,6,7] 旋转后为 [4,5,6,7,0,1,2])

* Example 1:

> Input: [1,3,5]
Output: 1

* Example 2:

> Input: [2,2,2,0,1]
Output: 0

## 思路 
和上一道题区别不大，主要在于元素可以重复，代码的变化点也是如何解决重复元素，之前不含重复元素的解法是这样，比较mid和right元素的大小，如果
正常情况应该mid小于right元素，那么right = mid，如果mid大于right则说明mid右侧的数组是旋转拼接后的一侧，而数组最小值就在旋转拼接处，所以
left = mid + 1; 这道题为什么不能照搬这个方法呢，原因就在于我们判断最小值在哪一侧的思路上，现在由于存在重复数字，所以当我发现mid和right
是相等的时候，我判断不出来最小值在哪一侧，所以我们遇到mid和right相等的时候继续缩小查找范围，令right--即可。
不理解为什么判断不出来最小值在哪一侧的话，可以仔细想一下，原本我们通过比较mid和right值判断，是因为数组单调递增，所以如果顺序发生了错乱
说明我们可以确定旋转的拼接点就在那一侧，但是有了重复元素的话，我们失去了单调递增的规律，那么自然就不知道真正的拼接点在哪一侧了

## 实现 
```
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
```
