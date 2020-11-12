# BinarySearchTreeIterator

## 题目
implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
实现一个二叉搜索树的迭代器，迭代器使用树的根节点初始化
调用next()方法会返回树中最小结点的值
 

Example:
\[7,3,15,null,null,9,20\]


BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 

Note:
next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST 
when next() is called.

next()和hasNext()方法的平均时间复杂度为O(1),空间复杂度为O(h)，h为树的高度。
可以假定next()方法永远是有效调用，即当调用该方法时，树中至少有一个最小节点
 
## 思路 
实现起来不难，观察下结果，输出的顺序依次是左节点，根节点和右节点，所以可以在构造函数中初始化一个中序遍历的LinkedList，调用next方法则是
从list头部移除元素，hasNext则是判断list是否为空。当然除此之外还可以用栈的方式，就不一一列举了，实现起来都不难。

## 实现 
```
public class BSTIterator {
    TreeNode root;
    List<Integer> list;

    public BSTIterator(TreeNode root) {
        this.root = root;
        list = new LinkedList<>();
        inOrderTraversal(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.remove(0);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return list.isEmpty();
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}
```