# BinaryTreeLevelOrderTraversalII

## 题目
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).
将一棵二叉树以自底向上的方式，将其每一层中的节点值输出到数组中（从左到右，从叶到根）
 
## 思路 
和之前I的区别是这次输出结果为反向输出了，那就是需要在插入list的时候每次都头插入就可以了，那么可以选择linkedlist，相对arraylist头插入
效率高一些

## 实现 
```
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        recursive(res, root, 1);
        return res;
    }

    private void recursive(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > res.size()) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level).add(root.val);
        recursive(res, root.left, level + 1);
        recursive(res, root.right, level + 1);
    }
```
