# RemoveDuplicatesFromSortedList

## 题目
Given a sorted linked list, delete all duplicates such that each element appear only once.
给一个已排序的链表，删除所有重复的元素使得每个元素只出现一次

Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
 
## 思路 
思路一般人都能想到，无非就是当数字重复就跳过这个节点，直接指向下一个节点，这里你可以利用一个set来实现去重，为了节约空间也可以直接用当前
节点val和下一个节点的val做比较，如果相等就使当前节点next等于当前节点next.next，做好空判断即可

## 实现 
```
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        ListNode curr = head;
        Set<Integer> set = new HashSet<>();
        while (curr != null) {
            if (set.add(curr.val)) {
                pre.next = new ListNode(curr.val);
                pre = curr;
            }
            curr = curr.next;
        }
        return fake.next;
    }

    public ListNode deleteDuplicatesII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
```