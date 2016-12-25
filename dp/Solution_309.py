#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
309. Best Time to Buy and Sell Stock with Cooldown   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 31636
Total Submissions: 80223
Difficulty: Medium
Contributors: Admin
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
'''

class Solution(object):


    # 反正都是追求利益最大化，在最大化的状态之间切换
    def maxProfitUseDp(self, prices):
        if len(prices) < 2:
            return 0
        prices_len = len(prices)
        s0 = [0] * prices_len
        s1 = [0] * prices_len
        s2 = [0] * prices_len
        s0[0] = 0
        s1[0] = -prices[0]
        s2[0] = float('-inf')
        for i in range(1,prices_len):
            s0[i] = max(s0[i-1], s2[i-1])
            s1[i] = max(s1[i-1], s0[i-1] - prices[i])
            s2[i] = s1[i-1] + prices[i]
        return max(s0[prices_len-1], s2[prices_len-1])

    def maxProfit(self, prices):
        if len(prices) < 2:
            return 0
        sell, buy, prev_sell, prev_buy = 0, -prices[0], 0, 0
        for price in prices:
            prev_buy = buy
            buy = max(prev_sell - price, prev_buy)
            prev_sell = sell
            sell = max(prev_buy + price, prev_sell)
        return sell

    # 其实有更好的想法
    def maxProfitBad(self, prices):
        """
        降到最低就买，升到最高就卖
        :type prices: List[int]
        :rtype: int
        """
        p_len = len(prices)
        dp = [0] * p_len + 1
        buy_point = -1
        # 添加哨兵
        prices.append(float('inf'))
        for i in range(0, p_len):
            # 还没有找到买入点
            if buy_point < 0 :
                if prices[i] < prices[i+1]:
                    if i == 0 or dp[i-1]>0:
                        buy_point = i
                continue
            # 找到买入点，但是降价或者股票价格不变直接卖出股票
            if prices[i] >= prices[i+1]:
                dp[i+1] = prices[i] - prices[buy_point] + dp[buy_point]
                buy_point = -1
            # 其他情况继续
        return dp[p_len]

