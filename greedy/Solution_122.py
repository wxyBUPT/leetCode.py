#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''
122. Best Time to Buy and Sell Stock II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 116269
Total Submissions: 257003
Difficulty: Medium
Contributors: Admin
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
'''

class Solution(object):
    # 要跌就卖，要涨就买
    # 使用贪心法
    # 25.20%
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        p_len = len(prices)
        last_index = p_len - 1
        max_profit = 0
        buy = -1
        for i in range(p_len):
            if buy < 0 and i < last_index and prices[i] < prices[i+1]:
                buy = prices[i]
                continue
            if buy >= 0 and (i == last_index or prices[i] > prices[i+1]):
                max_profit = max_profit - buy + prices[i]
                buy = -1
                continue
        return max_profit

    # 网友发现这道题非常简单
    # 51.22%
    def joke(self, prices):
        res = 0
        for i in range(len(prices) - 1):
            if prices[i] < prices[i+1]:
                res += (prices[i+1] - prices[i])
        return res

