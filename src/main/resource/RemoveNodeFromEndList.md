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
题目本身可以很简单的解出来，但是关键在于如何在O(n)时间复杂度内完成，要想在一次遍历内完成操作，其实只需要在遍历完成后能够准确的找到在链表结构中需要断开的位置即可，那么我们可以设置两个指针，一个指向低位，一个指向高位，两者的距离就是数字n，两个指针同时移动，当高位指针移动结束后，低位指针自然指向了需要断开的位置，那么只需要断开next节点并指向下下个节点即可。另外对于链表类操作的小技巧是在head前增加虚拟节点，这样在操作和返回中可以减少空指针判断

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