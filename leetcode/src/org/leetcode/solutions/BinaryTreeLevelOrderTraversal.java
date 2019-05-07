package org.leetcode.solutions;

import org.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2019/5/7 22:49
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        bfs(queue, res, list);
        return res;
    }
    // use breadth-first search, search the tree level by level
    private void bfs(Queue<TreeNode> queue, List<List<Integer>> res, List<Integer> list) {
        Queue<TreeNode> nextQueue = new LinkedList<>();
        TreeNode curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr != null) {
                list.add(curr.val);
                nextQueue.offer(curr.left);
                nextQueue.offer(curr.right);
            }
        }
        if (!nextQueue.isEmpty()) {
            res.add(new ArrayList<>(list));
            list.clear();
            bfs(nextQueue, res, list);
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        search(root, res, 0);
        return res;
    }

    private void search(TreeNode root, List<List<Integer>> res, int level) {
        if (root != null) {
            // new level, new list
            if (level >= res.size()) {
                res.add(new ArrayList<>());
            }
            // deepth-first search, but mark level
            // more efficiency
            res.get(level).add(root.val);
            search(root.left, res, level + 1);
            search(root.right, res, level + 1);
        }
    }
}
