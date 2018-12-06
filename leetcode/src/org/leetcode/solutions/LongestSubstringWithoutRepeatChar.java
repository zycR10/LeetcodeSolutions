package org.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatChar {
	// public int lengthOfLongestSubstring(String s) {
	// if (s == null) {
	// return 0;
	// }
	// int max = 0;
	// int[] nums = new int[26];
	// for (int i = 0; i < s.length(); i++) {
	// int count = 1;
	// // check special character (' ' - 'a' = -65)
	// // indexOutOfBoundException
	// if((s.charAt(i) - 'a') < 0) {
	// max = Math.max(count, max);
	// continue;
	// }
	// nums[s.charAt(i) - 'a'] = 1;
	// for (int j = i + 1; j < s.length(); j++) {
	// if((s.charAt(i) - 'a') < 0) {
	// max = Math.max(count, max);
	// break;
	// }
	// if (nums[s.charAt(j) - 'a'] == 1) {
	// max = Math.max(count, max);
	// break;
	// }
	// nums[s.charAt(j) - 'a'] = 1;
	// count++;
	// }
	// }
	// return max;
	// }

	// slide window
	// O(2n) = O(n)
	// public int lengthOfLongestSubstring(String s) {
	// int n = s.length();
	// Set<Character> set = new HashSet<>();
	// int ans = 0, i = 0, j = 0;
	// while (i < n && j < n) {
	// // try to extend the range [i, j]
	// if (!set.contains(s.charAt(j))) {
	// set.add(s.charAt(j++));
	// ans = Math.max(ans, j - i);
	// } else {
	// set.remove(s.charAt(i++));
	// }
	// }
	// return ans;
	// }

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				// if character is duplicate
				// j record the prev word location
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeatChar().lengthOfLongestSubstring(""));
	}
}
