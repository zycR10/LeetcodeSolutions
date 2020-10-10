# BestTimeTradeStockIII

## 题目
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
给定一个数组，其中第i个元素代表了第i天的股票价格
设计一个算法找到最大收益，最多只能进行两次交易
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
注意：不能同时操作多个交易(再次交易前必须将手里的股票卖出去)
 
## 思路 
不得不说这三道卖股票的题真有意思啊，虽然题干差不多，但是解题思路完全不同。这道题同样是找最大收益，但是最多只能交易两次，难就难在了这个限制
次数上，最多两次我们怎么看呢，这个要是想不到的话这道题会非常难办，既然说了最多两次，那么我们其实可以把两次拆开看
首先，假如只看第一次交易找最大值，那其实又回到了之前做过的题目上:
```
    public int maxProfit(int[] prices) {
        int buyFirst = Integer.MAX_VALUE;
        int sellFirst = 0;
        for (int p : prices) {
            buyFirst = Math.min(buyFirst, p);
            sellFirst = Math.max(sellFirst, p - buyFirst);
        }
        return sellFirst;
    }
```
在循环过程中不断的比较买入最小值和收益最大值即可，这种情况是一次交易的最大值，那么第二次交易呢？由于题干中明确说了，一次不能操作多个交易，
那么第二次交易是不是可以理解为也是一次单独的交易，只不过要在第一次之后，那么第二次和第一次交易区别在哪里？其实找最大值的方法肯定没有区别，
因为都是一次交易嘛，但是关键是第二次交易的时候你要计算的买入价格不一样了，因为通过第一次交易，你已经存在收益了，所以我再买的话，我起始金额
不再是0了，这个大家可以理解吧，就好像你真的买股票一样，第一次买那就是买多少就扔进去了多少，钱就放在股市里没有了着落，你的现金流里就是少了
你投入股市的钱，但是假如你运气好，挣了一万块，然后你决定再接再厉，再买一万五的，那么这个第二次投资其实相当于你目前现金流里只少了五千块，因为
你这次是带着收益再次进入股市的，这样说应该理解了吧？所以说我们计算第二次购买股票的起始价格，就不能是像第一次一样比较当前值和最小值中的较小值
了，而是比较当前值减去第一次收益之后和最小值去比得到更小值，而收益呢，收益没有区别，还是当前值减去你二次购买的起始值就是收益，但是记住，这个
收益值其实是包含了你第一次收益在内的最大收益，所以遍历数组之后，最后得到的值就是最多两次交易后的最大值

## 实现 
```
    public int maxProfit(int[] prices) {
        int buyFirst = Integer.MAX_VALUE;
        int buySecond = Integer.MAX_VALUE;
        int sellFirst = 0;
        int sellSecond = 0;
        for (int p : prices) {
            buyFirst = Math.min(buyFirst, p);
            sellFirst = Math.max(sellFirst, p - buyFirst);
            buySecond = Math.min(p, p - sellFirst);
            sellSecond = Math.max(p - buySecond, sellSecond);
        }
        return buySecond;
    }
```
