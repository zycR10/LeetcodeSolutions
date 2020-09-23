# BinaryTreeLevelOrderTraversal

## 题目 
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
给一棵二叉树，按层以从左至右的顺序返回二叉树的值

## 思路 
二叉树。。。用递归。。。不想说了，自己都嫌贫了

## 实现 
```
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        recursive(root, res, 0);
        return res;
    }

    private void recursive(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            recursive(root.left, res, level + 1);
        }
        if (root.right != null) {
            recursive(root.right, res, level + 1);
        }
    }
```