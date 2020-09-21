# BinaryTreeZigzagLevelOrderTraversal

## 题目
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).
给一棵二叉树，以之字形的顺寻返回节点值
 
## 思路 
有了另一个道[102. Binary Tree Level Order Traversal](https://github.com/zycR10/LeetcodeSolutions/blob/master/src/main/resource/BinaryTreeLevelOrderTraversal.md)的思路的话，这道题应该也不难解，
这两道题的区别就在于，前一道是一直按顺序排列树中每一层的节点，这道题是类似之字形的方式，一层正序一层倒序，上一题的话直接使用递归就可以了，
这道题也是一样递归，关键就在于递归的过程中判断出当前层要如何确定正序还是倒序，因为我们的方法参数中可以记录level，也就是当前对应的所在层数，
所以用第几层去判断当前层是正序或倒序即可，另外由于存在头插入这种操作，List需要使用LinkedList这种链表来操作

## 实现 
```
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            res.add(new LinkedList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }

        recursive(root.left, res, level + 1);
        recursive(root.right, res, level + 1);
    }
```
