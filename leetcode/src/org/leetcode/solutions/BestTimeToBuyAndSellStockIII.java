package org.leetcode.solutions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @Author: Zuo Yichen
 * @Date: 2019/7/15 12:26
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max1 = 0;
        int min = prices[0];
        int index = 1;
        while (index < prices.length) {
            if (prices[index] > min) {
                max1 = Math.max(max1, prices[index] - min);
            } else {
                min = prices[index];
            }
        }

        int max2 = 0;
        for (int i = 1; i < prices.length; i++) {
            // if tomorrow is more expensive than today, you should buy today and sell tomorrow
            max2 += Math.max(0, prices[i] - prices[i - 1]);
        }
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
    }
}
