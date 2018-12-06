package org.leetcode.solutions;

public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		if (s.length() == 1)
			return false;

		int len = s.length(), mid = len / 2; // half
		if (s.substring(0, mid).equals(s.substring(mid)))
			return true;

		int one_third = len / 3; // 1/3
		String sub = s.substring(0, one_third);
		if (sub.equals(s.substring(one_third, one_third * 2)) && sub.equals(s.substring(one_third * 2)))
			return true;

		if (len % 2 == 1) { // odd number of characters
			char c = s.charAt(0);
			for (int i = 1; i < len; i++) {
				if (s.charAt(i) != c)
					return false;
			}
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		new RepeatedSubstringPattern().repeatedSubstringPattern("ababababab");
	}
}
