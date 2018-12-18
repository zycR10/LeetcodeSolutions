package org.leetcode.solutions;

import java.util.Stack;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 *
 * @Author: Zuo Yichen
 * @Date: 2018/12/18 14:48
 */
public class WildcardMatching {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            // p stay in index of '*', s++ to find match character
            // there is something need to explain for 'match', eg. s: abcdefabcdefc p: ab*c
            // when find match, don't mean it's over, maybe it's only a wrong substring, and when you keep looking
            // maybe you can find another match character, maybe that's the right one.
            // in the example, you can first found * and charAt(p) == c, if you find c in s, you can find three times, which only the thrid time is right
            // so variable match means to record where the last match character found (first c and second c)
            // if something goes wrong, you can go back to match++ and keep looking next match character.
            else if (starIdx != -1) {
                p = starIdx + 1;
                s = ++match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else {
                return false;
            }
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
