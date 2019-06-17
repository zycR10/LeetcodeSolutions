package org.leetcode.solutions;

import org.leetcode.domain.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @Author: Zuo Yichen
 * @Date: 2019/6/13 23:13
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        TreeNode prev = null;
        constructLeftTree(root, prev);
    }

    private void constructLeftTree(TreeNode root, TreeNode prev) {
        if (root == null)
            return;
        constructLeftTree(root.right, prev);
        constructLeftTree(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
