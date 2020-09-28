# PathSum

## 题目
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along 
the path equals the given sum.
Note: A leaf is a node with no children.
给一棵二叉树和一个sum值，判断树中是否存在一条从根到叶的路径，使得这条路径的和为sum值
注意：叶节点的定义为没有子节点的节点
 
## 思路 
题目不难，从题干中可以看出其实就是要我们计算出二叉树每一条路径的值，然后判断值与所给的sum值是否相等，还是一个最基本的递归就可以解决问题，
不得不说递归确实是解决二叉树问题的银弹啊

## 实现 
```
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return recursive(root, sum, 0);
    }

    private boolean recursive(TreeNode root, int sum, int currSum) {
        if (root == null) {
            return true;
        }
        
        if (root != null && root.left == null && root.right == null) {
            return sum == (currSum + root.val);
        }

        currSum += root.val;
        return recursive(root.left, sum, currSum) || recursive(root.right, sum, currSum);
    }
```