package org.leetcode.solutions;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * @Author: Zuo Yichen
 * @Date: 2019/1/25 11:45
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // DP problem, first we can image to create a 2-dimension array to record edit distance
        // for example horse and ros can convert to a 2-dimension array :
        //Ø h o r s e
        //Ø 0 1 2 3 4 5
        //r 1 1 2 2 3 4
        //o 2 2 1 2 3 4
        //s 3 3 2 2 2 3
        // when row[i] != column[i], you can think found min(array[i-1][i-1], array[i-1][i], arrya[i][i-1]) + 1
        // because if you just add a character, you only need insert it from last minimun status.
        // when row[i] == column[i], array[i][i] = array[i-1][i-1]
        // because you add two same character to word1 and word2, so it's can be seen do nothing,as same as there is no this character.
        // so the state transition equation is :
        // dp[i][j] = dp[i - 1][j - 1]  word1[i] == word2[j]
        // dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1
        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
}
