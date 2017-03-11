package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 3/10/17.
 198. House Robber
 Difficulty: Easy
 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<=1)return 0;
        // 在i点买入股票能够获得的最大收益
        int[] buy=new int[len];
        // 在i点卖出股票能够获得的最大效益
        int[] sell=new int[len];
        buy[0]=-prices[0];
        buy[1]=-Math.min(prices[0],prices[1]);
        sell[0]=0;
        sell[1]=Math.max(0,prices[1]-prices[0]);
        for(int i=2;i<len;i++){
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i]=Math.max(buy[i-1]+prices[i],sell[i-1]);
        }
        return sell[len-1];
    }
}
