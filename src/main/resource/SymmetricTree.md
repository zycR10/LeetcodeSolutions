# SymmetricTree

## 题目 
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
给一棵二叉树，判断其结构是否对称

## 思路 
easy难度的题，解决办法也是easy，二叉树嘛，直接递归就完事儿了，不多解释了

## 实现 
```
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);
    }
```