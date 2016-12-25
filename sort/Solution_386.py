#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''
386. Lexicographical Numbers   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 11665
Total Submissions: 29889
Difficulty: Medium
Contributors: Admin
Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
'''

class Solution(object):

    # 90.57%
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = []
        curr = 1
        for i in range(n):
            res.append(curr)
            if curr * 10 <=n:
                curr *= 10
            elif curr%10 != 9 and curr+1<=n:
                curr+=1
            else:
                while (curr/10)%10 == 9:
                    curr/=10
                curr = curr/10+1
        return res



