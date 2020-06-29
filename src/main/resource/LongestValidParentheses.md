# LongestValidParentheses

## 题目 
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
给一个只包含字符'('和')'的字符串，找出查找最长的格式正确子字符串的长度

Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

## 思路
这道题是一道非常有意思的题目，因为解法非常多，而且每一种都有每一种的妙处，下面我来主要介绍三种：

第一种：利用栈操作
利用栈的原理，首先我们遍历字符串，当遇到左括号'('时，将其所在位置的下标值放入栈中，当遇到右括号')'，首先取出栈顶元素，然后用当前右括号的下标值减去当前栈顶元素的下标值。解释一下，这里是利用了下标值对长度进行计算，首先栈的原理不用多讲，我们只将左括号放入栈中，当遇到右括号时，如果栈中此时还有元素，说明栈顶的左括号与当前的右括号是一对，先将栈顶的元素取出，然后用当前右括号的下标值减去栈顶元素(即上一个左括号)的下标值，得到的值就是格式正确的子字符串长度，通俗点来说就是把已经成对出现的左括号取走，那么现在栈里剩下的都是未匹配的左括号，已成对的右括号减去未成对的左括号，得到的值就是当前正对出现的左右括号的长度，以此类推，遍历结束后取最大值即可。注意一些边界值和栈的空判断。

第二种：动态规划
动态规划解题实际是既复杂又简单的一种方式，复杂在需要推导出解题公式，简单在只要有了公式，完全将公式替换成代码就可以了。首先思考一下，正确的子串一定是以右括号为结尾，所以我们只需要在字符是右括号的时候进行判断，设立一个动态规划数据dp[]，当前下标为i

* 情况1
s[i] = ')' s[i-1] = '('
这种情况很简单，说明当前的右括号和前一位左括号是一类，也就是说目前存在一对'()'，那么动态规划公式为dp[i] = dp[i-2] + 2

* 情况2
s[i] = ')' s[i-1] = ')'
这种情况稍微复杂一些，如果连续两个右括号，说明目前无法匹配成一对，但是还要继续往前看是否能和前面的左括号成对，那么问题在于往前移动几位去判断呢？由于s[i-1]是右括号，那么对应在dp[i-1]处应该是该位置对应的连续正确子串的长度，所以减去这个长度即可，所以如果s[i - dp[i -1] - 1]处是左括号，即当前i处的右括号可以和前面的连续子串继续连接成一个格式正确的子串，那么dp[i] = dp[i - 1] + 2，但是这里仅仅是dp[i - 1] + 2是不够的，因为现在这种动态规划只是以右括号为标准进行处理，一旦右括号之间出现左括号，那么这种计算方式会遗漏掉，正确的公式是dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2，稍微有些复杂，给个例子'()(())'，可以根据这个例子反推一下就明白为什么了。

第三种：左右各遍历一次
这种方法可以说非常巧妙，从左和右各遍历一次，遍历过程中记录左括号和右括号的值
* 从左向右
如果左括号数量等于右括号数量，比较max值和左括号数量*2，
如果左括号数量小于右括号数量，计数归零

* 从右向左
如果左括号数量等于右括号数量，比较max值和左括号数量*2，
如果左括号数量大于右括号数量，计数归零

这样的解法其实是取巧的做法，因为左右括号必须连续出现才合法，而且输入的字符中只有左右括号，如果题目有变化那么就不再适用了，但不得不说很巧妙


## 实现 
```
方法一：利用栈操作
    public int longestValidParenthesesI(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // c is not '(' and stack is empty means string is start with n ')'
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(i - stack.peek(), max);
                }
            }
        }
        return max;
    }
```

```
方法二：动态规划（较复杂）
public int longestValidParenthesesII(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
```

```
方法三：左右各遍历一次(适用性不强，仅针对当前题目)
    public int longestValidParenthesesIII(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount ++;
            } else {
                rightCount ++;
            }
            if (leftCount == rightCount) {
                max = Math.max(max, leftCount * 2);
            } else if (leftCount < rightCount) {
                leftCount = rightCount = 0;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount ++;
            } else {
                rightCount ++;
            }
            if (leftCount == rightCount) {
                max = Math.max(max, leftCount * 2);
            } else if (leftCount > rightCount) {
                leftCount = rightCount = 0;
            }
        }
        return max;
    }
```