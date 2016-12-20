#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
319. Bulb Switcher   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 32708
Total Submissions: 78287
Difficulty: Medium
Contributors: Admin
There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3.

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off].

So you should return 1, because there is only one bulb is on.
'''

class Solution(object):

    # 28.19%
    # 就是考察质数的性质
    def bulbSwitch(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = 1
        while res * res < n:
            res += 1
        return res - 1
