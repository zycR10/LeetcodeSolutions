package com.leetcode.test;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					continue;
				} else {
					if (i - 1 < 0 || grid[i - 1][j] == 0) {
						perimeter++;
					}
					if (j - 1 < 0 || grid[i][j - 1] == 0) {
						perimeter++;
					}
					if (i + 1 == m || grid[i + 1][j] == 0) {
						perimeter++;
					}
					if (j + 1 == n || grid[i][j + 1] == 0) {
						perimeter++;
					}
				}
			}
		}
		return perimeter;
	}

	public static void main(String[] args) {
		IslandPerimeter ip = new IslandPerimeter();
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(ip.islandPerimeter(grid));
	}
}
