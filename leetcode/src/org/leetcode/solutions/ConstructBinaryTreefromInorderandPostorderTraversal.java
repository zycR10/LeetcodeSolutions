package org.leetcode.solutions;

import org.leetcode.domain.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @Author: Zuo Yichen
 * @Date: 2019/5/20 22:58
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(0, inorder.length - 1, inorder, postorder, postorder.length - 1);
    }

    private TreeNode constructTree(int start, int end, int[] inorder, int[] postorder, int index) {
        if (start > end || index < 0) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[index]);
        int rootIndex = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == node.val) {
                rootIndex = i;
                break;
            }
        }

        node.right = constructTree(rootIndex + 1, end, inorder, postorder, index - 1);
        node.left = constructTree(start, rootIndex - 1, inorder, postorder, index - (end - rootIndex) - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode node = new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder, postorder);
        System.out.println(node);
    }
}
