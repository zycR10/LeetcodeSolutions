# SortList

## 题目
Given the head of a linked list, return the list after sorting it in ascending order.
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
给一个链表的头节点head，返回排序后的链表
提示：排序的时间复杂度为O(nlogn)，空间复杂度为O(1)
 
## 思路 
在要求空间复杂度为O(nlogn)和O(1)后其实也没什么好办法了，首先O(nlogn)的排序算法常见的只有快排和归并排序，如果快排的话有一个问题，我们
这是个单向链表而不是数组，快排需要左右两个指针移动，对于从后向前移动我们没有办法解决，那么我们只剩下归并排序了。和数组归并唯一的不同在于
由于链表没有下标可以提供，所以我们每次分的时候采用慢指针和快指针的方式查找中间节点。

## 实现 
```
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode fake = new ListNode(0);
        ListNode tail = fake;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        }
        if (right != null) {
            tail.next = right;
        }
        return fake.next;
    }
```
