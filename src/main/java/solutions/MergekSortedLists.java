package solutions;

import org.leetcode.domain.ListNode;

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		return partition(lists, 0, lists.length - 1);
	}

	private ListNode partition(ListNode[] lists, int left, int right) {
		if (left == right) {
			return lists[left];
		}
		int mid = (left + right) / 2;
		if (left < right) {
			ListNode n1 = partition(lists, left, mid);
			ListNode n2 = partition(lists, mid + 1, right);
			return merge(n1, n2);
		} else {
			return null;
		}
	}

	private ListNode merge(ListNode n1, ListNode n2) {
		if (n1 == null) {
			return n2;
		}
		if (n2 == null) {
			return n1;
		}
		if (n1.val < n2.val) {
			n1.next = merge(n1.next, n2);
			return n1;
		} else {
			n2.next = merge(n1, n2.next);
			return n2;
		}
	}
}
