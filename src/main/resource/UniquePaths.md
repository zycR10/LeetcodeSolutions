# UniquePaths

## 题目
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there? 
有一个m * n的方格，假设一个机器人位于左上角的位置。
机器人只能向下或向右移动，请问如果有多少种可以到达右下角的路径？

## 思路
m * n的网格其实可以看作一个二维数组，数组中每一位的值都由其他位置推算得来，那么这属于典型的动态规划。
把网格看成数组nums\[n\]\[m\]，则数组nums\[i\]\[j\] = nums\[i - 1\]\[j\] + nums\[i\]\[j - 1\]，当然如果i和j为0的时候特殊处理即可
推导公式简单那么代码就非常容易写了
 
## 实现 
```
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = j > 0 ? dp[i][j - 1] : 1;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
```