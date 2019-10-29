package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2019/2/22 11:20
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            res.add(new ArrayList<>(subset));
            dfs(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new Subsets().subsets(nums);
    }
}
