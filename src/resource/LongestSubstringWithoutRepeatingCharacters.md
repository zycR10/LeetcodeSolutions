# Longest Substring Without Repeating Characters

## 题目
Given a string, find the length of the longest substring without repeating characters.
给定一个字符串，找到其中包含不重复字母的最长子串

Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

## 思路
寻找不重复字母可以理解为找到重复字母后就停止并记录这次连续不重复的值，并与最大值对比。这里有一个比较巧妙的思路是类似于滑动窗口的思想，设置一个左边界和一个右边界，假设字符i有重复字符i'，那么只需将左边界移动到字符i的后面一位为新的左边界即可。这里另一个技巧是检查字符是否重复，我们可以使用数组，set和hashmap等数据结构，如果确定了字符范围，例如英文字母或包含在ASCII码中的所有字符这种明确最大字符个数的字符集，那么可以使用数组来提高效率。

## 实现
```
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] chars = new int[128];
        int max = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            l = Math.max(l, chars[s.charAt(r)]);
            max = Math.max(max, r - l + 1);
            chars[s.charAt(r)] = r + 1;
        }
        return max;
    }
}
```