# SameTree

## 题目
Given two binary trees, write a function to check if they are the same or not.
写一个功能判断两棵树是否相同
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
相同要考虑到结构相同和节点值相同
 
## 思路 
esay难度的题，也确实是easy啊，之前也总结过，碰到树的题第一反应就是想递归，直接一个递归比较val就完事儿了，判断好null值即可，不多说了


## 实现
```
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
``` 
