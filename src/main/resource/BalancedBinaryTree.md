# BalancedBinaryTree

## 题目
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
判断一棵二叉树是否是平衡树，所谓平衡树就是指这棵树的左子树和右子树高度差不大于1
 
## 思路 
leetcode这题目排序有问题啊，做了好几道还原平衡二叉树的题了，然后又来了一道判断是不是平衡树的，感觉这种easy类型的题应该在同类题中往前放，
这样才能由浅入深的刷题嘛。这题思路真的懒得总结了，二叉树用递归，递归去算子树的深度，然后判断是否大于一即可，只是有一点我在做题的时候想了
很久也没解决，这种思路其实是有浪费的，比如已经找到有的子树不是平衡树了，那么整棵树就肯定不是平衡树了，但是这种算法仍然是要递归完所有节点才能
判断，但是优化的解法暂时没写出来，有写出来的大佬记得给我看看

## 实现 
```
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return calculateHeight(root) == null;
    }

    private Integer calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        Integer left = calculateHeight(node.left);
        Integer right = calculateHeight(node.right);

        if (left == null || right == null || Math.abs(left - right) > 1) {
            return null;
        }
        return Math.max(left, right) + 1;
    }
```