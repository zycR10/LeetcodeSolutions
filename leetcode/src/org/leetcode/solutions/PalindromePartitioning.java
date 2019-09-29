package org.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        partitionPalindrome(s, res);
        return res;
    }

    private void partitionPalindrome(String s, List<List<String>> res) {
        List list = new ArrayList();
        Set set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i, list, set);
            if (list != null && list.size() > 0) {
                res.add(new ArrayList<>(list));
                list.clear();
            }

            expandAroundCenter(s, i, i + 1, list, set);
            if (list != null && list.size() > 0) {
                res.add(new ArrayList<>(list));
                list.clear();
            }

        }
    }

    private void expandAroundCenter(String s, int left, int right, List list, Set set) {
        int L = left, R = right;
        String str;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            if (set.add(str = s.substring(L--, R++ + 1)))
                list.add(str);
        }
    }

    public static void main(String[] args) {
        new PalindromePartitioning().partition("aab");
    }
}
