package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @Author: Zuo Yichen
 * @Date: 2019/2/19 23:23
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
//        dfs(n, k, 0, 1, res, combination);
        dfs2(n, k, 1, res, combination);
        return res;
    }

    private void dfs(int n, int k, int index, int value, List<List<Integer>> res, List<Integer> combination) {
        if (index == k) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = value; i <= n; i++) {
            combination.add(value);
            dfs(n, k, index + 1, ++value, res, combination);
            combination.remove(combination.size() - 1);
        }
    }

    private void dfs2(int n, int k, int start, List<List<Integer>> res, List<Integer> combination) {
        if (k == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        // n-k+1
        // n means list size is n, so you need n elements, that means when only left n - 1 elements, this loop is over
        // so you should loop k - (n - 1) times
        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            dfs2(n, k - 1, i + 1, res, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Combinations().combine(4, 2);
    }
}
