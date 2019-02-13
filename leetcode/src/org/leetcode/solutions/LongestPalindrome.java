package org.leetcode.solutions;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
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
