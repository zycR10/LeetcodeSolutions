package org.leetcode.solutions;

import org.leetcode.domain.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @Author: Zuo Yichen
 * @Date: 2019/5/13 22:53
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int rootVal = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i ++) {
            if (rootVal == inorder[i]) {
                index = i;
            }
        }
        return constructTree(index, preorder, inorder);
    }

    private TreeNode constructTree(int index, int[] preorder, int[] inorder) {
        TreeNode node = new TreeNode(inorder[index]);

    }
}
