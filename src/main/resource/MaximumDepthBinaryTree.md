# MaximumDepthBinaryTree

## 题目
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
给一棵二叉树，找到这棵树的最大深度
 
## 思路 
就这？这也太简单了，根据我们前面一次又一次提到过的，解二叉树用什么？递归，找个终止条件，写好中间计算代码就成了，终止条件是啥？root==null呗，
中间计算是啥？层数+1然后和一个最大值比呗，最后返回左子树和右子树中的最大值即可，不过这道题我在写的时候由于受到了前面问题的影响，又搞了个
recursive方法，然后还传入了curr和max，表示当前层数和最大层数，然后每次去比较curr和max，取更大值，最后返回左子树和右子树中层数更深的结果，
但是实际上这道题可以优化到只有三行代码（详见实现中的方法一），因为你想一下，解决这道题相当于只有两步：1.每层计数加一，空节点终止返回；2.每个
根节点都取它左子树和右子树中的更大值。基于这个思路，写个三行代码就行了，详见实现中的方法二

## 实现
```
方法一：
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recursive(root, 0, Integer.MIN_VALUE);
    }

    private int recursive(TreeNode root, int curr, int max) {
        if (root == null) {
            return max;
        }

        if (++curr > max) {
            max = curr;
        }
        return Math.max(recursive(root.left, curr, max), recursive(root.right, curr, max));
    }
    
方法二：
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }    
``` 
