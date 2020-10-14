# PalindromePartitioning

## 题目
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
给一个字符串s，将这个字符串分割成每个子字符串都是回文字符串
返回所有可能的分割方法

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 
## 思路 
抛开数组不看，在一个数组中返回所有可能的组合，基本就是个回溯算法的框架了。题目中所谓的把字符串分割成每一个子字符串都是回文字符串，其实说白
了就是通过回溯遍历所有可能的子字符串，然后每次都判断是否是回文，如果是就继续搜索，如果不是跳过就可以了。分析清楚了就会发现，题目看起来不是
很好解决，但是其实就是回溯+回文，回溯已经写过很多次了，回文判断更简单了，给两个下标left和right，判断每一位是否相同即可。

## 实现 
```
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }

        backTrack(res, s, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(List<List<String>> res, String s, int start, ArrayList<String> list) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (checkPalindrome(start, i, s) && list.add(s.substring(start, i + 1))) {
                backTrack(res, s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean checkPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
```