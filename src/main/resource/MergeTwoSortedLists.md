# Merge Two Sorted Lists

## 题目
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
合并两个有序list

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

## 思路
方法一：由于两个list都是已排序，所以只需要按照元素大小排序即可，思路也很简单，只需要从前向后分别移动两个list，设置一个指针指向当前的较小值，任何继续往后移动指针即可。另外链表题中的一个通用技巧是设置一个傀儡头节点，最后返回改节点的next值即可，省去很多判空的操作
方法二：简单递归调用即可，相当于是归并排序最后的合并步骤

## 实现
方法一：
```
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l1 != null)
            head.next = l1;
        else 
            head.next = l2;
        
        return dummy.next;
}
```

方法二：
```
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
```