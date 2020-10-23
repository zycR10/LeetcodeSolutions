# LinkedListCycle

## 题目
Given head, the head of a linked list, determine if the linked list has a cycle in it.
给定头节点，判断链表是否有环
 
## 思路 
这道题可以算是一道简单又常见的面试算法题了，虽然这么说不好，但是这种题，就算是背也要给背下来，否则的话面试的时候面对这么简单一道题还做不出来，
那基本就没戏了吧。在链表中找环的基本思路就是设计两个指针，一个走的快，一个走的慢，遍历过程中去比较两个指针是否有相同的时刻即可，你也可以简单
理解为跑步被套圈儿了

## 实现 
```
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
```
