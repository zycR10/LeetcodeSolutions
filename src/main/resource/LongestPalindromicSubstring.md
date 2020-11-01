# Longest Palindromic Substring

## 题目
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
在给定的字符串中找到最长的回文子字符串，假定字符串最大长度为1000

Example 1:
>Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

>Input: "cbbd"
Output: "bb"

## 思路
对于寻找回文不要想的太复杂，最简单最有效的方式就是从中心开始，两个指针一个向左一个向右各自移动，直到指针所指元素不同为止，记录下长度然后
与最大长度比较即可。由于题目中要返回最长子串，所以需要找到最大长度后通过中心位分别减去和加上maxlength/2得到左右边界，这里有一个小技巧，
可以想象一下，假如字符串是奇数个字符，那么ok，中心位加减maxlength/2正好得到左右边界，但如果是偶数个字符的话，那么maxlength/2将会导致左边界多减了1，
所以一个小trick就是算左边界的时候用（maxlength - 1）/2，因为对于java的除运算来说，奇数和它本身减一除以2结果相同，但是偶数减一后结果值小1，
正好满足我们的情况，思路理清了之后代码就异常简单了。

## 实现
```
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
```