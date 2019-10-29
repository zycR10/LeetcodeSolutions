package solutions;

import org.leetcode.domain.TreeNode;

public class MinimumAbsoluteDifference {
	private int min = Integer.MAX_VALUE;
	private Integer prev = null;

	public int getMinimumDifference(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		getMinimumDifference(root.left);
		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;
		getMinimumDifference(root.right);
		return min;
	}
}
