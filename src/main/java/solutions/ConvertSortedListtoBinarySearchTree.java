package solutions;

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
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode start, ListNode end) {

        if (start == null || start == end)
            return null;

        ListNode fast = start;
        ListNode slow = start;

        while (fast.next != end && fast.next.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(start, slow);
        root.right = sortedListToBST(slow.next, end);

        return root;
    }

    public static void main(String[] args) {
        String input = "[0,1,2,3,4,5]";
        ListNode node = ListNodeUtils.stringToListNode(input);
        new ConvertSortedListtoBinarySearchTree().sortedListToBST(node);
    }
}
