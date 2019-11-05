package solutions;

import domain.TreeNode;

import java.util.*;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/5/8 23:03
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode curr, List<List<Integer>> res, int level) {
        if (curr == null) {
            return;
        }

        if (res.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }

        List<Integer> collection = res.get(level);
        if (level % 2 == 0) {
            collection.add(curr.val);
        } else {
            // to be honest, this answer copy from discussion under this problem
            // I totally forget method #add(index, val)
            collection.add(0, curr.val);
        }

        travel(curr.left, res, level + 1);
        travel(curr.right, res, level + 1);
    }
}
