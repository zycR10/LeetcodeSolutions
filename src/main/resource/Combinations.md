# Combinations

## 题目
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
You may return the answer in any order.
给两个整数n和k，从1到n中选择k个数字排列返回结果，对结果的顺序没有要求

Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:
Input: n = 1, k = 1
Output: [[1]]
 
## 思路 
类似于这种按顺序排列组合的题目回溯算法都可以轻松解决，代码比较简单，只说一个优化点，这道题由于只要k个数，所以是可以提前终止循环的，
假设有0到n，需要取k个数，那其实我们在选择第一个数的时候只需要选择到n - k + 1的位置即可，这么说有点儿抽象，假如n = 4, k = 2，那么结果是[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]，
观察一下结果，没有[4,1],[4,2]这种和前面的[1,4],[2,4]算重复的，不需要计算，也就是说最多循环到以3为第一位的时候就可以终止了，当然在每次递归调用的时候不要忘记k - 1

## 实现 
```
   public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), 1, n ,k);
        return res;
    }

    private void backTrack(List<List<Integer>> res, ArrayList<Object> curr, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList(curr));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            curr.add(i);
            backTrack(res, curr, i + 1, n, k - 1);
            curr.remove(curr.size() - 1);
        }
    }
```