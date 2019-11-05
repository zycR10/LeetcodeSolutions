package solutions;

import java.io.IOException;

import domain.ListNode;
import domain.ListNodeUtils;

public class SwapNodesinPairs {
	// public ListNode swapPairs(ListNode head) {
	// if ((head == null)||(head.next == null))
	// return head;
	// ListNode n = head.next;
	// head.next = swapPairs(head.next.next);
	// n.next = head;
	// return n;
	// }

	// loop is more efficient than recursion
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		prev.next = head;
		while (prev.next != null && prev.next.next != null) {
			ListNode first = prev.next;
			ListNode second = prev.next.next;
			first.next = second.next;
			second.next = first;
			prev.next = second;
			prev = first;
		}
		return dummy.next;
	}

	public static void main(String[] args) throws IOException {
		String line = "[1,2,3,4]";
		if (line != null) {
			ListNode head = ListNodeUtils.stringToListNode(line);
			ListNode res = new SwapNodesinPairs().swapPairs(head);
			String out = ListNodeUtils.listNodeToString(res);
			System.out.print(out);
		}
	}
}
