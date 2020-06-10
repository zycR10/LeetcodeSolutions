# Valid Parentheses

## 题目
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
给定一个仅包含'(', ')', '{', '}', '[', ']'这几个特殊符号的字符串，判断输入是否合法

An input string is valid if:
合法条件：
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
括号一开一闭相对应
括号开闭顺序要一致

## 思路
题目不难理解，是让判断给定字段串是否符合括号规则，括号规则很简单，前后的左右括号相对应，后开的括号要先关，所以数据结构中的栈完美的符合括号开闭逻辑，所以只需要借助栈操作即可。

## 实现
```
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
```