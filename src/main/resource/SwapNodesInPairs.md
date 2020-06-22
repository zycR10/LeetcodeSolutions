# Swap Nodes in Pairs

## 题目 
Given a linked list, swap every two adjacent nodes and return its head.
给定一个linkedlist，两两相邻节点交换
You may not modify the values in the list's nodes, only nodes itself may be changed.
不可以修改节点中的值进行交换，只能通过交换节点完成

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.

## 思路
说实话，不知道这道题为什么是medium难度的，思路非常简单，两个指针去折腾就可以了，直接看实现吧

## 实现 
```
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		prev.next = head;
		while (prev.next != null && prev.next.next != null) {
			ListNode first = prev.next;
			ListNode second = prev.next.next;
			first.next = second.next;
			second.next = first;
			prev.next = second;
			prev = first;
		}
		return dummy.next;
	}
```