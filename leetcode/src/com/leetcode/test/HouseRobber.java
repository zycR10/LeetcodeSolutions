package com.leetcode.test;

public class HouseRobber {
	public int rob(int[] nums) {
		int prevNo = 0;
		int prevYes = 0;
		int temp;
		for (int n : nums) {
			temp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = n + temp;
		}
		return Math.max(prevNo, prevYes);
	}
}
