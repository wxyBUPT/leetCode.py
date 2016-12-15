#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
118. Pascal's Triangle   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 109782
Total Submissions: 301615
Difficulty: Easy
Contributors: Admin
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
'''

class Solution(object):

    # 55.80%
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """

        if not numRows:
            return []

        res = []
        res.append([1])
        for i in range(1,numRows):
            i_len = i + 1
            tmp = [1] * i_len
            for j in range(1, i_len -1):
                tmp[j] = res[i-1][j-1] + res[i-1][j]
            res.append(tmp)
        return res

    # 很显然上述算法不能体现python语言的特性
    # 下面算法只要简单的几行

    # 77.84%
    def totolipton(self, numRows):
        res = [[1]]
        for i in range(1, numRows):
            res += [map(lambda x,y:x + y, res[-1] + [0], [0] + res[-1])]
        return res[:numRows]
