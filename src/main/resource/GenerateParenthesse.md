# Generate Parentheses

## 题目
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
给定括弧的数量，生成所有可能的组合情况

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

## 思路
解题的关键在于括号是一一对应的关系，无论怎样排列，一定都是n个左括号先写完n个，然后对应的写右括号到n个，只不过在写左括号的过程中可以穿插写入右括号，保证左括号永远大于等于右括号即可。
思路有了的话代码就很简单了，其实就是把上面这句话翻译成代码即可，因为排列组合是有变化的，所以我们需要在写完某种情况之后，不断地回到之前的情景中去，明显回溯算法很适合这样的场景。

## 实现
```
    public List<String> backtrack(int n) {
        String str = "";
        List<String> res = new ArrayList<>();
        backtrack(str, res, 0, 0, n);
        return res;
    }

    private void backtrack(String str, List<String> res, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left < n) {
            backtrack(str + "(", res, left++, right, n);
        }
        if (left > right) {
            backtrack(str + ")", res, left, right++, n);
        }
    }
```