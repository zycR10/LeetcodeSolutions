# BestTimeTradeStock

## 题目
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
给定一个数组，数组中的元素i代表了第i天的股票价格。
在只允许进行一次交易的情况下，设计一个算法计算出最大收益。

Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.             

Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

## 思路
首先如果整个数组是降序排列的，那么就不存在所谓的收益，所以就是0，那么也就是说我们要找到相对上升的区间，所以设置一个min值作为当前的最小值，
另外设置一个max记录最大收益，对数组进行遍历，当前位置的元素小于最小值的话，那么就将当前值记为最小值；如果比最小值大，那么就计算差值并与最大
利益max进行比较。
 
## 实现 
```
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
```
