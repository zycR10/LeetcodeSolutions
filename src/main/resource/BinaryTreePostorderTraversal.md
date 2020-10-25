# BinaryTreePostorderTraversal

## 题目
Given the root of a binary tree, return the postorder traversal of its nodes' values.
输入为二叉树的根节点，返回二叉树后序遍历
 
## 思路 
后序遍历全网可能也就这么一个优雅的解法了，背也得背下来

## 实现 
```
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }
```