package solutions;

import domain.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// define a sentinel head
		// avoid outOfBoundError or NPE
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;
		ListNode left = sentinel;
		ListNode right = sentinel;
		for (int i = 1; i <= n + 1; i++) {
			right = right.next;
		}
		while (right != null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return sentinel.next;
	}
}
