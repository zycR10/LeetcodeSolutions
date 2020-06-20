# MergeKsortedLists

## 题目 
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
合并k个已排序的list

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

## 思路 
典型的合并已排序list问题，前面处理过一篇[合并两个已排序list问题](https://github.com/zycR10/LeetcodeSolutions/blob/master/src/main/resource/MergeTwoSortedLists.md)，这道题只不过是变成了k个，所以相比之前的实现方法，我们只是多了一步分解即可，类似于归并排序的思想即可，两两合并最后完全合并

## 实现 
```
   public ListNode mergeKLists(ListNode[] lists) {
        return split(0, lists.length - 1, lists);
    }

    public ListNode split (int start, int end, ListNode[] node) {
        if (start == end) {
            return node[start];
        }

        int partition = start + (end - start) / 2;
        ListNode left = split(start, partition, node);
        ListNode right = split(partition + 1, end, node);
        return merge(left, right);
    }

    public ListNode merge (ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
```