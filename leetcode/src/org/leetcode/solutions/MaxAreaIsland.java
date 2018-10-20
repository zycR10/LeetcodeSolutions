package org.leetcode.solutions;

public class MaxAreaIsland {
	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, count(grid, i, j));
				}
			}
		}
		return max;
	}

	private int count(int[][] grid, int i, int j) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
			grid[i][j] = 0;
			return 1 + count(grid, i + 1, j) + count(grid, i - 1, j) + count(grid, i, j + 1) + count(grid, i, j - 1);
		}
		return 0;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
		System.out.println(new MaxAreaIsland().maxAreaOfIsland(grid));
	}
}
