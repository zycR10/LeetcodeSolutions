package solutions;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Note: m and n will be at most 100.
 *
 * @Author: Zuo Yichen
 * @Date: 2019/1/11 16:32
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        // always make m is the bigger one
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        // use int can overflow
        // math problem, caculate C m n
        long res = 1;
        for (int i = 1; i < n; i++) {
            res *= m + n - i - 1;
            res /= i;
        }
        return (int) res;
    }

    public int uniquePathsByDP(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    continue;
                }
                res[j] += res[j - 1];
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
    }
}
