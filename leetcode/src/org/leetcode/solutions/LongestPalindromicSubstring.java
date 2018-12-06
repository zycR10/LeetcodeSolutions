package org.leetcode.solutions;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			// center maybe like b of aba
			int len1 = expandAroundCenter(s, i, i);
			// center maybe like bb of abba
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				// for even, you should exclude center itself
				// so, len - 1 means 4 / 2 - 1 = 3 / 2
				// for odd, len - 1 don't affect on result
				// means, 5 / 2 = 4 / 2
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
}
