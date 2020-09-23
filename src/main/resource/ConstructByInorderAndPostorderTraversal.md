# ConstructByInorderAndPostorderTraversal

## 题目
Given inorder and postorder traversal of a tree, construct the binary tree.
通过中序和后序遍历重建一棵二叉树
 
## 思路 
要是会了上一道通过前序和中序重建二叉树的题，那么这道题应该也没问题了吧，通过后序和中序重建二叉树就是把之前的过程反过来了，后序的特点是先
输出左子树，然后右子树，然后是根节点，所以这次是从后往前找根节点，注意递归的时候由于是从后往前，所以需要先重建右子树，再重建左子树，其他过程
和之前的题没有任何区别

## 实现 
```
    int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        index = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(inorder, postorder, 0, inorder.length - 1, map);
    }

    private TreeNode recursive(int[] inorder, int[] postorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            index--;
            return new TreeNode(inorder[start]);
        }
        int root = postorder[index--];
        TreeNode node = new TreeNode(root);
        int split = map.get(root);
        node.right = recursive(inorder, postorder, split + 1, end, map);
        node.left = recursive(inorder, postorder, start, split - 1, map);
        return node;
    }
```
