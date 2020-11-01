# ReorderList

## 题目
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.
给定一个单向链表l0->ln，反转链表为L0→Ln→L1→Ln-1→L2→Ln-2→…，不能够改变链表中的值，只能改变节点本身的顺序

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 
## 思路 
翻转链表的基本套路，举个例子，比如1，2，3，4四个节点，我现在想要翻转2和3怎么做，首先三个指针指向1，2，3，然后断开2和3的连接，令2.next = 4，
再断开3和4的连接，令3.next = 2，最后1.next = 3即可。
仔细思考一下为什么是这样的顺序，因为我们操作链表的时候有一个前提就是指针不能丢，也就是说一旦断开了某个连接，一定要保证还可以连回来才行，然后
我们来看我们的操作：
1.首先断开2和3，2指向4，为什么可以断开，因为我们有指针指向3，所以可以断开指向3的连接
2.断开3和4，3指向2，为什么可以断开，因为上一步我们已经2指向了4，所以相当于现在也有了指向4的指针
3.断开1和2，1指向3，同理，上一步3已经指向了2，所以这里可以断开和2的连接

## 实现 
```
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        // find mid
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse post part list
        ListNode pre = slow.next;
        ListNode curr;
        while (pre.next != null) {
            curr = pre.next;
            pre.next = curr.next;
            curr.next = slow.next;
            slow.next = curr;
        }

        // merge two part
        curr = slow.next;
        while (head != slow) {
            slow.next = curr.next;
            curr.next = head.next;
            head.next = curr;
            head = curr.next;
            curr = slow.next;
        }
    }
```