# BinaryTreeInorderTraversal

## 题目
Given a binary tree, return the inorder traversal of its nodes' values.
实现二叉树中序遍历

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 
## 思路 
也没啥好讲的，前中后序遍历都固定了，背也得背下来了

## 实现 
```
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
```