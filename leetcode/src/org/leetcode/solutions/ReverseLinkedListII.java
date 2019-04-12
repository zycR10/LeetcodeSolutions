package org.leetcode.solutions;

import org.leetcode.domain.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @Author: Zuo Yichen
 * @Date: 2019/4/10 12:14
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode mListNode = new ListNode(0);
        ListNode nListNode = new ListNode(0);
        ListNode premListNode = new ListNode(0);
        ListNode node = fakeNode;
        for (int i = 0; i < n; i ++) {
            if (i == m - 2) {
                premListNode = node;
            }
            if (i == m - 1) {
                mListNode = node;
            }
            if (i == n - 1) {
                nListNode = node.next;
            }
            node = node.next;
        }
        for (int i = m; i < n; i ++) {
            mListNode.next = nListNode;
            nListNode = mListNode;
            mListNode = mListNode.next;
        }
        premListNode.next = nListNode;
        return fakeNode.next;
    }
}
