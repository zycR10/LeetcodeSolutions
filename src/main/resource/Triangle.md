# Triangle

## 题目
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
给一个可以看作是三角形的输入数组，找到从顶到底的最小路径，每一步只能移动到下一行相邻的元素上。

例子：
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
最好空间复杂度为O(n)
 
## 思路 
这道题可以归类于走格子求最短路径和的题目，这类题目应该使用动态规划去做比较简单，同时题目中特殊要求空间复杂度为O(n)，所以应该使用一维数组解决
问题。这道题正向推导其实不难，但是会遇到一些问题，首先我在做这道题的时候自己在纸上写出来如果手工推导的过程，写的过程中你会发现这就是一个动态
规划的过程，由于下一层的某个节点一定是由该节点左上方或者右上方其中一个节点走过来的，所以这个过程就是核心的方程式，即f(n) = f(n) + f(n - 1)，
但是这里有一个边界处理问题就是三角形最左侧和最右侧两条路，这两条路从顶到底只能是一条路走下来，所以不适合我们上面说的公式，当然了，你可以把dp数组
扩展两位0，相当于将三角形边缘补齐，我在写的时候没有这么做，而是特别处理了两头的边界值，只需要简单的累加就可以了，具体解法见方法一。

方法一虽然已经解决了问题，但是总看着有点儿不爽对不对，不仅有边界值需要考虑，最好还要从所有结果中遍历去寻找最小值，所以我们换一种思路，为什么
我们最后没有直接找到最小值呢，因为最小路径肯定要从最后一层的某一位中找到，但是我们不知道具体最后会走到哪一位上，所以只能罗列出所有，所有再
遍历比较，那有什么办法能让我们这个路径越走越窄呢？重点来了，倒着走啊，同样一条路径，正着走和倒着走没有区别对吧？但是三角形越往上走越窄啊，
所以还是和刚刚完全一样的思路，我们从底往上走f(n) = f(n) + f(n + 1)，方法二就是这种思想的实现，可以看到可读性和简洁度都大大提高了。


## 实现 
```
方法一：
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int length = triangle.size();
        int[] sums = new int[length];
        sums[0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            List<Integer> list = triangle.get(i);
            sums[i] = sums[i - 1] + list.get(i);
            for (int j = i - 1; j > 0; j--) {
                sums[j] = Math.min(sums[j - 1], sums[j]) + list.get(j);
            }
            sums[0] += list.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i : sums) {
            min = Math.min(min, i);
        }
        return min;
    }

方法二：
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
```