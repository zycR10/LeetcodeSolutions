# FlatternBinaryTreeToLinkedList

## 题目
把一棵二叉树展开成一个链表
 
## 思路 
乍一看挺简单的，但是和之前的二叉树解法稍有不同。总体思路还是递归没问题，观察一下特点，其实最后就是把所有左子树都变成右子树，然后整棵树只有
右节点有数据，使一棵树变成了一个链表。关键就在于把左子树变成右子树，因为我们肯定是递归的去操作，从叶子节点开始变化，把最底层的节点拼接好之后
再往上继续拼接，这里我们的思想是每次递归的方法中使用left和right分别指向root的左右子树对象，然后root的左子树就可以直接置空了，因为结果中
没有左子树，直接将左子树放在右子树的位置上，由于这个左子树已经是拼接过的了，所以我们利用一个循环直接走到叶子节点上，直接再把右子树拼接到后面
就可以了。

## 实现 
```
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 暂存左子树和右子树
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 递归调用
        flatten(left);
        flatten(right);

        // 1.使左子树为空，由于已经暂存左子树到left中了，这里放心大胆的置空
        // 2.把原左子树移动到右子树
        root.left = null;
        root.right = left;
        // 移动指针到右子树(已经被换成左子树了)的叶子节点
        while (root.right != null) {
            root = root.right;
        }
        // 到此为止左子树已经到了右子树的位置，而且root指针已经指到了现在右子树的叶子节点
        // 剩下就是把原来的右子树拼到后面就可以了
        root.right = right;
    }
```
