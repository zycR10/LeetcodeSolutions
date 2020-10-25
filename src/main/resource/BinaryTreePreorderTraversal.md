# BinaryTreePreorderTraversal

## 题目
Given the root of a binary tree, return the preorder traversal of its nodes' values.
输入为二叉树的根节点，返回二叉树前序遍历
 
## 思路 
前序遍历全网可能也就这么一个优雅的解法了，背也得背下来

## 实现 
```
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
```