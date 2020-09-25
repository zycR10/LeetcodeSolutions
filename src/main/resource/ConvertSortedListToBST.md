# ConvertSortedListToBST

## 题目
按升序排列的链表转化为平衡二叉树
 
## 思路 
这道题给大家提供一个链表的通用思路，首先用链表重建和用数组重建的主要区别是啥？我们回忆一下用数组重建的过程，由于数组我们可以获取长度，所以很
容易找到mid值，但是链表就不一样了，无法直接获取链表长度，除非你的数据结构里特殊处理过，那么我们怎么快速找到链表中点呢？有一个好办法就是快慢
指针，一个一次走两步，一个一次走一步，当快指针走到了tail的时候就停，此时慢指针所指的就是中点，找到中点之后的处理肯定又是递归啦，和数组处理上
就没有什么区别了。

## 实现 
```
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return recursion(head, null);
    }

    private TreeNode recursion(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = recursion(head, slow);
        node.right = recursion(slow.next, tail);
        return node;
    }
```
