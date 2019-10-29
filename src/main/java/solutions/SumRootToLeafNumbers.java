package solutions;

import org.leetcode.domain.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * 1
 * / \
 * 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * <p>
 * Input: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 * @Author: Zuo Yichen
 * @Date: 2019/8/1 23:38
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s) {
        if (n == null) {
            return 0;
        }
        if (n.right == null && n.left == null) {
            return s * 10 + n.val;
        }
        return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
    }
}

