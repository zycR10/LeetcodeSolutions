# BestTimeTradeStockII

## 题目
Say you have an array prices for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(i.e., buy one and sell one share of the stock multiple times).
给一个数组，数组中的元素股票在当天的价格，允许进行多次交易的情况下，设计一个算法找出最大收益

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 
## 思路 
这道题同之前的题比，变化在于可以多次交易，其实多次交易反而让问题简单了，设想一下怎么买股票最牛逼？我今天买，明天涨就买了，然后一直这样我就
一直挣钱对吧？当然这是不考虑手续费等问题。所以这道题翻译过来就是，最大收益 = 只要当前元素大于前面元素，我就累加。

## 实现 
```
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sum;
    }
```