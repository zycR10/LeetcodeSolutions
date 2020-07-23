# JumpGameII

## 题目 
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
给一个正整数数组，假设你的初始位置是数组中的第一位，数组中的每个元素代表了你当前所能跳跃的最大值，你的目标是用最少的跳跃次数跳到数组的最后一位

Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
先跳一步，再跳三步，最少跳两次到达

Note:
You can assume that you can always reach the last index.
你可以认为你一定能够到达最后一位

## 思路 
首先其实要注意题目的提示，提示了可以认为永远存在解，所以例如某一位是0的情况我们就不需要考虑了，这道题在一些博客甚至leetcode上都有人说用贪心算法来解，
其实是错误的，首先，贪心算法是说在当前情况下取最优结果，那么显然对于这道题来说，你每一次都选跳最远距离并不能保证你用了最短的次数到达终点，其实应该是广度优先算法，
通过计算每一跳的各种可能步数下的最远距离，最后求得最小跳跃次数，举个例子，首先遍历数组，比如数组第一位是3，说明我可以跳1，2，3步，那么我在跳1步的情况下会跳到nums[1]，而在nums[1]的位置我能再跳到达的最远距离就是1 + nums[1]，以此类推分别计算2 + nums[2] 和 3 + nums[3]，通过比较后得到这三步的最大值，这个得到的最大值就一定是我在前两跳的最优解，因为我已经把第一步的第1，2，3种跳法都计算了，此时最远值我们记录为max，并且记录一个end值与max相等，这个end值要作为我们待会计数的终点，然后我们用这样的方法继续向后遍历，每一位对应的最远距离就是n + nums[n]，持续的比较max的大小，当数组下标到达end时说明我已经跳到了前n跳中理论上的最远距离，那么我们此时就可以将跳跃次数+1，因为当前这次跳跃最远也只能到这里了，那么下一跳的理论最远距离在哪里呢？就是此时的max，因为你已经把前end - 1个元素的最大值比较了一遍，当前max就是对应的最大值，也就是我们下一跳的end值，以此类推，直到遍历结束为止

## 实现 
