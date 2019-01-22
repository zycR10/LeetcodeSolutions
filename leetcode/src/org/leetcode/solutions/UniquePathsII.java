package org.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * <p>
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * @Author: Zuo Yichen
 * @Date: 2019/1/22 17:53
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        int rowLength = obstacleGrid.length;
        int columnLength = obstacleGrid[0].length;
        int result = 1;
        if (rowLength == 0 || columnLength == 0) {
            return 0;
        }
        if (rowLength == 1 || columnLength == 1) {
            return 1;
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (obstacleGrid[i][j] == 1) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        rowLength = rowLength - rowSet.size();
        columnLength = columnLength - columnSet.size();
        if (rowLength < columnLength) {
            int temp = rowLength;
            rowLength = columnLength;
            columnLength = temp;
        }
        for (int n = 1; n < columnLength; n++) {
            result *= columnLength + rowLength - n - 1;
            result /= n;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        new UniquePathsII().uniquePathsWithObstacles(obstacleGrid);
    }
}
