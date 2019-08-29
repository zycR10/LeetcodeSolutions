package org.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2019/8/7 12:24
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        List<List<String>> res = new ArrayList<>();
//        partitionPalindrome(s, );
    }
}
