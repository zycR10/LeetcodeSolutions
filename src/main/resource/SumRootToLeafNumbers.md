# SumRootToLeafNumbers
## 题目 
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
给一棵二叉树，其中仅包含0-9的数字，从根到叶节点可以代表为一个数字
例如1->2->3就代表了123。求这棵树所有根到叶子节点的和

Example:
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

## 思路 
题目很长其实解法非常简单，首先看到二叉树，又是这种需要遍历根到叶节点的题目，那么大概率就是使用递归解题。既然是从根到叶遍历，并且计算总和，
那么首先就明确了递归的终止条件就是到叶节点，当判断当前节点为叶结点时返回这条路径代表的数字，并在外层做加法即可，但是遍历过程中有一种特殊情况，
题目中只说了这是一棵二叉树，并没有说是完全二叉树或者其他限制条件，所以有可能某个节点只有一棵子树，那么当访问到空节点时直接返回0即可。再有就
是如何计算当前路径的值，由于是从根走到叶，从高位走到低位，所以每走一层就将当前已计算值乘10并且加上当前节点值即可。

## 实现
```
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumAll(root, 0);
    }

    private int sumAll(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        return sumAll(root.left, sum * 10 + root.val) 
                + sumAll(root.right, sum * 10 + root.val);
    }
``` 
