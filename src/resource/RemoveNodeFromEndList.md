# Remove Nth Node From End of List

## 题目
Given a linked list, remove the n-th node from the end of list and return its head.
给定一个链表，从链表尾部去掉第n个节点并且最终返回链表头部

Example:

>Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.

## 思路

## 实现
```
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;
        
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return start.next;
    }
```