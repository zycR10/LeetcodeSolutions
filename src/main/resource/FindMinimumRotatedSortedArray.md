# FindMinimumRotatedSortedArray

## 题目
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Return the minimum element of this array.
假设一个按升序排列的数组在某个不知道的点上进行了旋转，返回数组中的最小值
例如：\[0,1,2,4,5,6,7\]以2和4中间为轴旋转，变成了\[4,5,6,7,0,1,2]

* Example 1:
> Input: nums = [3,4,5,1,2]  
Output: 1

* Example 2:
> Input: nums = [4,5,6,7,0,1,2]  
Output: 0

* Example 3:
> Input: nums = [1]  
Output: 1
 
## 思路 
一道不太像medium难度的题，有序数组中找某个值，听起来就应该像二分查找那边靠拢，如果你想不到也没关系，这么想一下，最简单的做法是什么？遍历
数组，只要遇到当前元素小于前一个元素，就说明走到了旋转后的拼接处，而当前元素就是最小值对不对？算法复杂度是O(n)，而这听起来就不是一个正经
的算法题答案，那比O(n)更牛逼的的是啥？O(logn)，什么查找算法能达到这个时间复杂度？二分查找咯。
这里需要思考的点在于，每次移动需要朝左侧还是右侧移动，很显然我们应该朝最小值所在的那一侧移动，而最小值在哪一侧就取决于num\[mid\]和num\[left\]，
num\[right\]比较大小的结果，如果mid值大于right值，说明旋转的拼接处是在mid的右侧，因为正常升序排列的话mid都是小于right的，所以当mid大于
right时，我们就应该向右侧移动去查找最小值，否则我们就像左侧走。这里有一个小坑，二分查找一般写习惯，left = mid + 1、right = mid - 1，这里
right可不能减一了，为啥不能呢？因为你并不能确定mid值是否就是最小值，那为啥left依旧加一呢，因为你向右侧移动的时候已经确定了mid大于right值，
所以mid肯定不是最小值了。

## 实现 
```
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
```
