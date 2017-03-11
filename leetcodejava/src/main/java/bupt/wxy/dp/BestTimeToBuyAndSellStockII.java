package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 3/10/17.
 122. Best Time to Buy and Sell Stock II Add to List
 Difficulty: Easy
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {

    // 同样设置两个状态
    // 1.84%
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<2)return 0;
        // 在当前时刻买入股票获得的最大收益
        int[] buy=new int[len];
        // 在当前时刻卖出股票获得的最大收益
        int[] sell=new int[len];
        buy[0]=-prices[0];
        sell[0]=0;
        buy[1]=-Math.min(prices[0],prices[1]);
        sell[1]=Math.max(0,buy[0]+prices[1]);
        for(int i=2;i<len;i++){
            buy[i]=Math.max(buy[i-1],sell[i-1]-prices[i]);
            sell[i]=Math.max(buy[i-1]+prices[i],sell[i-1]);
        }
        return sell[len-1];
    }
}