package org.leetcode.solutions;

/**
 *
 *
 * @Author: Zuo Yichen
 * @Date: 2019/1/11 16:32
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1 ) {
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
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(51,9));
    }
}
