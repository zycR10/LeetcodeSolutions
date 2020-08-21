# ClimbingStairs

## 题目
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
爬楼梯问题，每次只能爬一步或者两步，一共有多少种爬到顶的方法？

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 
## 思路 
典型到不能再典型的动态规划，那就老规矩，推导方程写出来问题就解决了，由于每一步只能跳1或2步，所以dp\[n\] = dp\[n - 1\] + dp\[n - 2\]

## 实现 
```
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }
```