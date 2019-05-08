package org.leetcode.solutions;

import org.leetcode.domain.TreeNode;

import java.util.*;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/5/8 23:03
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        TreeNode node;
        int i = 1;
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node != null) {
                list.add(node.val);
                nextStack.push(node.left);
                nextStack.push(node.right);
            }
            if (--i == 0) {
                res.add(new ArrayList<>(list));
                list.clear();
            }
            i *= 2;
        }
        return res;
    }
}
