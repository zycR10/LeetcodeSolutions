# BinaryTreeMaxPathSum

## 题目
Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.
给一棵非空二叉树，找到路径和的最大值。
对于本题来说，路径的定义是树中至少一个节点即可

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 
## 思路 
这居然是一道hard难度的题目，但是竟然感觉做出来很简单？难道说...是我太强了么...开个玩笑，一道二叉树并且是求路径最大和的题目，那么整体的大框架
肯定是递归没问题，通过递归比较左右子树的更大值，然后加上根节点的值继续向上传递，但是这样传递的是当前子树的最大值，和题目要求的最大值有些
区别，因为这个答案里不一定非得是从叶子最顶部的根，只要至少包含一个节点即可，也就是说子树中的任意链接，甚至单个节点都有可能是最大值，要处理这个
其实也不难，定义一个成员变量，在每次计算出最大值的时候进行比较即可。简单总结一下思路就是按照递归的方法计算所有可能的路径和，在每一次求出当前
路径和的时候都与max值去比较，最后返回max值

## 实现 
```
public class BinaryTreeMaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        sumMax(root);
        return max;
    }

    public int sumMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, sumMax(root.left));
        int right = Math.max(0, sumMax(root.right));

        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
```