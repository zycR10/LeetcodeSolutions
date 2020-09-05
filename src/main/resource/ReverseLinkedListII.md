# ReverseLinkedListII

## 题目
Reverse a linked list from position m to n. Do it in one-pass.
Note: 1 ≤ m ≤ n ≤ length of list.
给两个数字m，n，从m 到n 的位置翻转该链表，请在一次循环内完成操作

Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 
## 思路 
整体来讲思路不难，只要理清楚链表引用关系即可，我的思路是由于从m 到n 翻转链表，所以首先找到m - 1的位置，记录改位置的ListNode为pre节点，
m位置上的节点记为curr节点，每一次翻转相当于将curr的下一节点从链表中断开，curr连接到后面的节点，然后将断开的节点连接到pre的后面，这样就相当于
完成了节点的颠倒

## 实现 
```
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode curr = head;
        ListNode pre = fake;
        ListNode tmp;
        int count = 1;
        while (curr != null && count < n) {
            if (count >= m && curr.next != null) {
                tmp = curr.next;
                curr.next = curr.next.next;
                tmp.next = pre.next;
                pre.next = tmp;
            } else {
                pre = pre.next;
                curr = curr.next;
            }
            count++;
        }
        return fake.next;
    }
```
