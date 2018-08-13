package com.leetcode.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int a = target - nums[i];
			if (map.get(a) != null && map.get(a) != i) {
				res[0] = i;
				res[1] = map.get(a);
				break;
			}
		}
		return res;
	}
}
