# SortColors

## 题目
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.
给一个数组，数组中的元素代表0，1，2分别代表了红，白，蓝，将数组中的元素按照0，1，2排序

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
一个思路是遍历两次，一次计算出0的个数，一次计算出1的个数，然后再将数组重写，能否用一次遍历解决问题？
 
## 思路 
题目里说了一堆没用的，其实就是给数组排序，说实话，任何一个原地排序的算法都可以解决问题，但是这肯定不是出题者的本意，题目中明确是有0，1，2，所以可以设置两个指针zeroIndex和twoIndex
分别指向数组起始和最终位置，也就是分别代表了0和2的位置，遍历数组，如果遇到0，就与zeroIndex互换位置，遇到2就与twoIndex交换位置，交换之后要记得
当前遍历的index要减一处理，因为交换之后当前位置的值就变了，要再判断一次

## 实现 
```
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for (int i = 0; i <= twoIndex; i++) {
            if (nums[i] == 0 && i > zeroIndex) {
                nums[i] =  nums[zeroIndex];
                nums[zeroIndex++] = 0;
                i--;
            } else if (nums[i] == 2 && i < twoIndex) {
                nums[i] = nums[twoIndex];
                nums[twoIndex--] = 2;
                i--;
            }
        }    
    }
```