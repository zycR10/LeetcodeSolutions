package solutions;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * @Author: Zuo Yichen
 * @Date: 2019/1/17 17:28
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int colum = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i != 0 && j != 0) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[row - 1][colum - 1];
    }

    public int minPathSum2(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        return minPathSum(grid, 0 ,0, res);
    }

    private int minPathSum(int[][] grid, int row, int column, int[][] res) {
        if (row == grid.length - 1 && column == grid[0].length - 1) {
            return grid[row][column];
        }
        if (row >= grid.length || column >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (res[row][column] == 0) {
            res[row][column] = grid[row][column] + Math.min(minPathSum(grid, row + 1, column, res), minPathSum(grid, row, column + 1, res));
        }
        return res[row][column];
    }
}
