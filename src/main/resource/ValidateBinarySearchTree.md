# ValidateBinarySearchTree

## 题目
Given a binary tree, determine if it is a valid binary search tree (BST).
给一棵二叉树，判断是否是一棵正确的二叉搜索树

Assume a BST is defined as follows:
二叉搜索树定义如下：
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
左子树的节点都要小于根节点
右子树的节点都要大于根节点
左子树和右子树都必须是二叉搜索树

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 
## 思路 
涉及树的问题一般情况下不出意外的话使用递归去解决问题，这道题解起来有一个坑需要注意，假如每次递归只是判断左右节点和parent节点的大小的话其实
忽略了一个问题，因为二叉搜索树不只是说子节点比父节点大或者小，而是一个节点的右子树都要比他本身大，所以只比较上一层明显有问题，解决也简单，只需要
记录一个当前子树的最大值和最小值就可以了

## 实现 
```
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        return validate(root.left, lower, val) && validate(root.right, val, upper);
    }
```