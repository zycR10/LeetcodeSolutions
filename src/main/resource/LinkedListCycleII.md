# LinkedListCycleII

## 题目
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following 
the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
给一个链表，返回链表中环的起始位置，如果没有环则返回空。

Notice that you should not modify the linked list.Can you solve it using O(1) (i.e. constant) memory?
注意不要修改原链表，且使用常量存储空间
 
## 思路 
这道题蛮有意思的，值得大家思考一下。首先放弃引入其他数据结构，比如map或者set然后进行判断的想法吧，听起来就不是个好算法，况且题目中也明确
提示你了，用常量额外空间。想一下怎么才能解出来这道题，如果我知道了从起点到环入口位置有多长，那么问题就简单了，所以说我们要想办法找到起点到
环入口的长度。观察一下环，环的最大特点就是可以套圈对吗，所以我们在这个特性上做文章，想一下之前的两个指针一快一慢的解法，为什么最后可以相遇，
因为快指针把慢指针给套圈了，那我们来看一下两个指针的路程，慢指针走了一段环外的路记为a，走了一段环内的路记为b，快指针走了一段a，一段b，然后
又走了一段换上的路并且返回到了环起点记为c，然后又走了一段b最后和慢指针相遇，所以写成公式a+b+c+b = 2(a + b)对吧？简化一下最后剩下啥了？是不是
a = c？那a是什么，是不是就是我们前面想要的起点到环入口的距离。也就是说当快慢指针相遇后，如果我们再定义一个指针从head节点开始走，而慢指针继续
往后走，慢指针走过c距离，新指针走过a距离，最后两个指针就在环入口相遇了。

## 实现 
```
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode res = head;
                while (res != slow) {
                    res = res.next;
                    slow = slow.next;
                }
                return res;
            }
        }
        return null;
    }
```