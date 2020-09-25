# ConvertSortedArrayToBST

## 题目
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of 
every node never differ by more than 1.
给一个元素以升序排列的数组，将其转化为一棵平衡二叉搜索树
平衡二叉树的定义为一棵树左右子树的节点高度差不大于1
 
## 思路 
easy level，easy solution，整体用递归不用讲，要保证节点高度差不大于1，那么可以每次都取中心点为根节点

## 实现 
```
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return recursive(nums, 0, nums.length - 1);
    }

    private TreeNode recursive(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recursive(nums, start, mid - 1);
        node.right = recursive(nums, mid + 1, end);
        return node;
    }
```
