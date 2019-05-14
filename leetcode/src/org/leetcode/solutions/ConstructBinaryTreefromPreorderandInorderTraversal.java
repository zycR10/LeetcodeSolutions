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
        return constructTree(0, inorder.length - 1, preorder, inorder, 0);
    }

    private TreeNode constructTree(int start, int end, int[] preorder, int[] inorder, int index) {
        if (start == end) {
            return new TreeNode(inorder[start]);
        }
        int root = preorder[index];
        TreeNode node = new TreeNode(-1);
        int rootIndex = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root) {
                node = new TreeNode(root);
                rootIndex = i;
                break;
            }
        }
        if (rootIndex != 0) {
            node.left = constructTree(start, rootIndex - 1, preorder, inorder, ++index);
        }
//        if (rootIndex != inorder.length - 1) {
            node.right = constructTree(rootIndex + 1, end, preorder, inorder, ++index);
//        }
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 3, 2};
        new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preorder, inorder);
    }
}
