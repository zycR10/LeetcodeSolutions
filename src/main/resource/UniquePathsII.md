# UniquePathsII

## 题目
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
在一个m * n的方格中，假设一个机器人初始化在左上角的位置，每次只能向下或向右移动一格，找出移动到右下角的所有路径
假设在网格中有障碍物存在 
 
Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right 
 
## 思路 
和上一道Unique Paths虽然有变化，但是变化非常小，只是在格子中增加了"障碍物"，解题思路完全一致，只是在循环中判断一下，由于障碍物是不可达的，
所以只要遇到障碍物，就把该位置的计数置为0就可以，同时对上一题的dp数组做了一点儿优化，上一题中我们使用了二维数组，相当于完全模拟出m * n每一个
格子对应的走法个数，实际上机器人由于只能向右和向下无法回头，所有前面已走过的格子没有保留的意义，而计算当前格子实际上只与左边和上边的数值有关，
所以生成一个m或者n的数组均可满足要求

## 实现 
```
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid.length;
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 0; i < obstacleGrid[0].length ; i++) {
            for (int j = 0; j < length; j++) {
                if (obstacleGrid[j][i] == 1) {
                    result[j] = 0;
                } else {
                    result[j] = j > 0 ? result[j] + result[j - 1] : result[j];
                }
            }
        }
        return result[length - 1];
    }
```