# PalindromePartitioningII

## 题目
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
给一个字符串s，将字符串拆分为多个字符串，每个拆分后的字符串都是回文。
返回拆分需要的最少切割数。

Example 1:
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:
Input: s = "a"
Output: 0

Example 3:
Input: s = "ab"
Output: 1
 
## 思路 
这道题有点儿难度，主要是开始做的时候思维固定了，觉得肯定也是回溯，然后在回溯过程中累加值，在最后终止条件的判断中比较最小值即可，但是可能是
由于算法本身时间复杂度较高，在提交的过程中会出现Time Limit Exceeded。其实这道题不见得需要使用回溯，动态规划也是一种很好的解法，因为这道题
是不是可以理解为像是我们曾经做过的走台阶的问题，给定一个数组，每一位的元素代表了当前位置最长能走的步数，计算是否能到达最后一位，这里的步长
其实就可以换成我们中间某个回文的长度。从某一位开始我们分别向左和向右出发，查看是否满足回文条件，推导公式为dp\[right\]=min(dp\[start - 1\] + 1,
dp\[right\])，因为每一个字符都要求是回文，所以当前回文终点位置的切割数肯定就是前一个回文终点切割数加一，有一种特殊情况就是当left已经
等于0了，那么说明从开始位置到right位置是一整个回文，所以不需要切割，所以dp\[right\] = 0。

## 实现 
```
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int length = s.length();
        int[] dp = new int[length];
        
        // 每一位初始化，最差的情况为长度n，切n-1刀，即找不到任何子字符串是回文的
        for (int i = 0; i < length;i++) {
            dp[i] = i;
        }

        for (int i = 0; i < length; i++) {
            // 假设回文为奇数长度，所以left和right在同一位置
            findMin(s, i, i, dp);
            // 假设回文为偶数长度，所以left和right相邻
            findMin(s, i, i + 1, dp);
        }
        return dp[length - 1];
    }

    private void findMin(String s, int left, int right, int[] dp) {
        // 循环终止条件：1.left或者right超出边界 2.字符出现不同，即已经不构成回文
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                // 从起止位置开始一直满足回文，不需要切割
                dp[right] = 0;
            } else {
                // 比较right位置最小切割数和当前切割数
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
```
