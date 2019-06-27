package org.leetcode.solutions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @Author: Zuo Yichen
 * @Date: 2019/6/26 22:59
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int max = 0;
        int size = prices.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (prices[j] > prices[i]) {
                    int temp = prices[j] - prices[i];
                    max = Math.max(max, temp);
                }
            }
        }
        return max;
    }

    public int maxProfitII(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int max = 0;
        int low = 0;
        int fast = 1;
        while (fast < prices.length) {
            if (prices[fast] > prices[low]) {
                max = Math.max(max, prices[fast] - prices[low]);
            } else {
                low = fast;
            }
            fast++;
        }
        return max;
    }

    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        int index = 1;
        while (index < prices.length) {
            if (prices[index] > min) {
                max = Math.max(max, prices[index] - min);
            } else {
                min = prices[index];
            }
        }
        return max;
    }
}
