# ConstructByPreorderAndInorderTraversal

## 题目
Given preorder and inorder traversal of a tree, construct the binary tree.
给了一棵树的前序遍历和中序遍历，要求重建这棵树
 
## 思路 
通过前序和中序遍历重建二叉树，分析前序特点：先输出根节点，然后是左子树，然后是右子树，所以前序遍历第一位就是树的根节点。再分析中序遍历的
特点：先输出左子树，然后输出根节点，最后输出右子树，所以如果知道了根节点，那么可以从中序遍历中区分出左子树和右子树。所以我们的思路就是从
前序拿到根节点，然后去中序查找位置，然后分为左子树和右子树，然后对左子树和右子树重复操作上述步骤，就可以重建整棵二叉树

## 实现 
```
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(preorder, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int left, int right, Map<Integer, Integer> map) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            index++;
            return new TreeNode(inorder[left]);
        }
        int root = preorder[index++];
        TreeNode rootNode = new TreeNode(root);

        int split = map.get(root);
        rootNode.left = construct(preorder, inorder, left, split - 1, map);
        rootNode.right = construct(preorder, inorder, split + 1, right, map);
        return rootNode;
    }
```