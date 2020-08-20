# MinimumPathSum

## 题目
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
给一个m * n的网格，其中每一位都包含了一个非负数字，
现在要从左上角移动到右下角，找到所用数字和最小的路径

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 
## 思路
典型的动态规划，创建一个动态规划数组dp，由于只能向下或者向右移动，所以只需要取当前位置左侧或上方中sum值更小的一个即可，同样可以将二维的dp数组优化到一维
 
## 实现 
```
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int width = grid[0].length;
        int height = grid.length;
        int[] dp = new int[height];
        dp[0] = grid[0][0];
        for (int i = 1; i < height; i++) {
            dp[i] = grid[i][0] + dp[i - 1];
        }
        for (int i = 1; i < width; i++) {
            for (int j = 0; j < height; j++) {
                dp[j] = (j == 0 ? dp[j] : Math.min(dp[j], dp[j - 1])) + grid[j][i];
            }
        }
        return dp[height - 1];
    }
```