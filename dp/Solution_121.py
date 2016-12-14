#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
121. Best Time to Buy and Sell Stock   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 150449
Total Submissions: 387314
Difficulty: Easy
Contributors: Admin
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
'''

class Solution(object):

    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0

        max_profit = 0
        min_price = prices[0]
        prices_len = len(prices)
        for i in range(1, prices_len):
            if prices[i] > min_price:
                max_profit = max(max_profit, prices[i] - min_price)
            else:
                min_price = prices[i]
        return max_profit


