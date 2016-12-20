#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
 216. Combination Sum III

    Total Accepted: 53023
    Total Submissions: 127776
    Difficulty: Medium
    Contributors: Admin

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]


Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
'''

class Solution(object):

    # 由此可见已经打破算法的最低记录了
    # 58.32%
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        res = []
        self.backtracking(k, n, res, [], 1)
        return res

    def backtracking(self, k, n, res, curr, i):

        if k == 0 and n == 0:
            res.append(curr[:])
            return
        if k < 0 or n < 0:
            return
        for j in range(i, 10):
            curr.append(j)
            self.backtracking(k-1, n-j, res, curr, j+1)
            curr.pop()



    # 根本不算是聪明的回溯
    def backtrackingbad(self, k, n, res, curr, i):
        '''

        :param k: 还要选择k个数
        :param n: 还要选择的和
        :param res: 所有的结果
        :param curr: 当前选择的结果
        :param i: 从i开始选
        :return:
        '''
        if k == 1 :
            if i <= n and n <10:
                curr.append(n)
                res.append(curr)
            return
        if i<9 and n >= i:
            dis_chose = curr[:]
            chose = curr[:]
            chose.append(i)
            self.backtracking(k, n, res, dis_chose, i+1)
            self.backtracking(k-1, n-i, res, chose, i+1)



