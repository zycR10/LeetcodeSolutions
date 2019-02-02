package org.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/2/2 19:50
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] searchSet = new int[256];

        final int t_len = t.length();
        final int s_len = s.length();
        for (int i = 0; i < t_len; i++)
            searchSet[t.charAt(i)]++;

        int left = 0, right = 0, charsToFind = t_len;
        int minLeft = 0, minLen = Integer.MAX_VALUE;

        //slide the window
        while (right < s_len) {

            //slide right border until we do not find all required chars
            while (right < s_len && charsToFind > 0) {
                char c = s.charAt(right);

                //only entries for chars from t can be positive
                if (searchSet[c]-- > 0) {
                    charsToFind--;
                }
                right++;
            }

            //slide left border while we still have all required chars
            while (charsToFind == 0) {

                if (minLen > right - left) {
                    minLen = right - left;
                    minLeft = left;

                    if (minLen == t_len) {
                        break;
                    }
                }

                //if entry became positive, this means this one is from the original t list
                char c = s.charAt(left);
                if (searchSet[c]++ == 0) {
                    charsToFind++;
                }

                left++;
            }
        }

        if (minLen != Integer.MAX_VALUE)
            return s.substring(minLeft, minLeft + minLen);
        else
            return "";
    }
}
