#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import datetime
'''
77. Combinations   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 99933
Total Submissions: 265515
Difficulty: Medium
Contributors: Admin
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
'''

class Solution(object):

    # 83.49
    def combine(self, n, k):
        if n == k or k ==0:
            return [range(1,k+1)]
        return self.combine(n-1, k) + map(lambda x:[n]+x, self.combine(n-1, k-1))

    # 89.88% 中间根据条件减掉了很多分支
    # 自己做测试两种算法基本差不多
    def combinebt(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        res = []
        self.backtracking(range(1,n+1), 0, k, res, [])
        return res

    def backtracking(self, all_int, index, total, res, curr):
        len_curr = len(curr)
        if len_curr == total:
            res.append(curr[:])
            return
        if len_curr+len(all_int)-index<total:
            return

        curr.append(all_int[index])
        self.backtracking(all_int, index+1,total, res, curr)
        curr.pop()
        self.backtracking(all_int, index+1, total, res, curr)

if __name__ == "__main__":

    COUNT = 1000
    sl = Solution()
    before = datetime.datetime.now()
    for i in range(COUNT):
        sl.combine(30,28)
    after = datetime.datetime.now()
    print u'使用combine方法一共花费了%d ms' % (after-before).microseconds

    before = datetime.datetime.now()
    for i in range(COUNT):
        sl.combinebt(30,28)
    after = datetime.datetime.now()
    print u'使用combinebt方法一共花费了%d ms' % (after - before).microseconds

