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
        int buyOne = Integer.MAX_VALUE, buyTwo = Integer.MAX_VALUE;
        int sellOne = 0, sellTwo =  0;
        for (int price : prices) {
            // same as just one trans, keep looking minimum buy and the most profit.
            buyOne = Math.min(buyOne, price);
            sellOne = Math.max(sellOne, price - buyOne);

            // if you have earn 100, and today you need pay 300, you can say today cost you 200
            // because 100 is your profit, this buyTwo can be seen store sellOne status
            // based on sellOne, now you can use the same way to look the most profit by two trans.
            buyTwo = Math.min(buyTwo, price - sellOne);
            sellTwo = Math.max(sellTwo, price - buyTwo);
        }
        // why return sellTwo, because sellTwo is always >= sellOne
        // if only one trans means the price is always go up, so price - buyTwo = price - (price - sellOne) = sellOne
        // sellTwo = Math.max(sellTwo, sellOne) = sellOne (sellOne is calculate first, and sellTwo is zero)
        return sellTwo;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
    }
}
