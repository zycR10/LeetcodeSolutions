package com.leetcode.test;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int res = 0;
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            if (arr[c] == 1) {
                res += 2;
                arr[c] = 0;
            } else {
                arr[c] = 1;
            }
        }
        return Math.min(s.length(), res + 1);
	}

	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("bb"));
	}
}
