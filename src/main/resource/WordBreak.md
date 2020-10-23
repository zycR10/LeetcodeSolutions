# WordBreak

## 题目
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 
## 思路 
首先我们肯定会想到暴力搜索，怎么个暴力搜索呢，比如遍历字符串的每一位，然后判断当前子字符串是否在worddict中，如果存在，那么就以当前位置为
起点再分出第二个子字符串，继续遍历，判断是否存在，如果还存在就继续，如果不存在就回退到上一个分割的位置，然后从该位置继续往下遍历。这种做法
肯定是完全可以的，但就是效率低下，低下的主要原因是我们做了很多次无用的判断，例如给定字符串为abcdef，worddict中的值为a,ab,bcd,cd,ef，这时
我们会发现a和bcd还有ab和cd虽然是两种组合方法，但是实际上组合出来效果是一样的都是abcd，那么也就是对于d这个切割位置来说，其实不必在意是哪种
组合方式，反正这个位置一定可以分隔，也就是说我们需要一个之前位置的状态值，告诉我这个位置是否可以切割，然后我在这个状态值的基础上继续往下遍历，
如果遇到状态值已经设置的位置，就说明不需要再判断了，那这不就是典型的动态规划，需要推导公式即可，根据我们上面分析的，假设两个字符串的位置分别
为x和y，那么dp(y) = dp(x) && if(worddict has s(y - x))，也就是说截止到y位置能否在worddict中找到，取决于x位置是否能找到，以及x到y这段
子字符串是否在dict中

## 实现 
```
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        return dfs(s, wordDict, dp, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int[] dp, int i) {
        if (i == s.length() || dp[i] == 1) {
            return true;
        }
        if (dp[i] == -1) {
            return false;
        }
        for (String word : wordDict) {
            if (s.startsWith(word, i) && dfs(s, wordDict, dp, i + word.length())) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = -1;
        return false;
    }
```