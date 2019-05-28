package org.leetcode.solutions;

import org.leetcode.domain.ListNode;
import org.leetcode.domain.ListNodeUtils;
import org.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @Author: Zuo Yichen
 * @Date: 2019/5/26 18:32
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nodes = new LinkedList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        int index = nodes.size() / 2;
        TreeNode root = new TreeNode(nodes.get(index));
        root.left = constructTree(nodes, 0, index - 1);
        root.right = constructTree(nodes, index + 1, nodes.size() - 1);
        return root;
    }

    private TreeNode constructTree(List<Integer> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(0);
        TreeNode root = node;
        for (int i = end; i >= start; i--) {
            node.left = new TreeNode(nodes.get(i));
            node = node.left;
        }
        return root.left;
    }

    public static void main(String[] args) {
        String input = "[0,1,2,3,4,5]";
        ListNode node = ListNodeUtils.stringToListNode(input);
        new ConvertSortedListtoBinarySearchTree().sortedListToBST(node);
    }
}
