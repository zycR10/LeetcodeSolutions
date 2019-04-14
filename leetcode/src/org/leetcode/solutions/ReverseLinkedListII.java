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
        if (head == null) {
            return null;
        }
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode pre = fakeNode;
        for(int i = 0; i < m - 1; i ++) {
            pre = pre.next;
        }
        ListNode former = pre.next;
        ListNode after = former.next;
        // change order two by two
        // pre -> former -> after -> else
        // pre -> former -> else  after -> else
        // pre -> former ->else after -> former
        // pre -> after -> former -> else
        for (int i = m; i < n; i++) {
            former.next = after.next;
            after.next = pre.next;
            pre.next = after;
            after = former.next;
        }
        return fakeNode.next;
    }
}
