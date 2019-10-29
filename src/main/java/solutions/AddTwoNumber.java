/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

package solutions;


import domain.ListNode;

public class AddTwoNumber {

    // forget range for integer is 2147483647
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		int num1 = parseNum(l1);
//		int num2 = parseNum(l2);
//		Integer sum = num1 + num2;
//		ListNode res = new ListNode(sum % 10);
//		ListNode curr = res;
//		while (sum >= 10) {
//			sum = sum / 10;
//			ListNode next = new ListNode(sum % 10);
//			curr.next = next;
//			curr = next;
//		}
//		return res;
//	}
//
//	private int parseNum(ListNode node) {
//		if (node == null) {
//			return 0;
//		}
//		int index = 1;
//		int result = 0;
//		while (node != null) {
//			result += node.val * index;
//			index *= 10;
//			node = node.next;
//		}
//		return result;
//	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sum(l1, l2, false);
    }

    private ListNode sum(ListNode l1, ListNode l2, boolean isOverTen) {
        if (l1 == null && l2 == null) {
            if (isOverTen) {
                return new ListNode(1);
            }
            return null;
        }
        ListNode node = new ListNode(0);
        int overTen = isOverTen ? 1 : 0;
        if (l1 == null) {
            node.val = (l2.val + overTen) % 10;
            node.next = sum(null, l2.next, (l2.val + overTen) >= 10);
            return node;
        }
        if (l2 == null) {
            node.val = (l1.val + overTen) % 10;
            node.next = sum(l1.next, null, (l1.val + overTen) >= 10);
            return node;
        }
        int sum = l1.val + l2.val + overTen;
        node.val = sum % 10;
        node.next = sum(l1.next, l2.next, sum >= 10);
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        ListNode curr = l2;
        for (int i = 0; i < 9; i++) {
            ListNode next = new ListNode(9);
            curr.next = next;
            curr = next;
        }

        ListNode res = new AddTwoNumber().addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
