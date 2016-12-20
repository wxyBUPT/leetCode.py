#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import collections

'''
423. Reconstruct Original Digits from English   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 4945
Total Submissions: 11867
Difficulty: Medium
Contributors: Admin
Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"
'''

class Solution(object):

    # 很神奇的算法
    def originalDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        d = collections.Counter(s)
        res = []
        for x in '0eroz 6six 7evens 5fiev 8eihtg 4ourf 3treeh 2tow 1neo 9nnei'.split():
            res.append(x[0] * d[x[-1]])
            for c in x:
                d[c] -= d[x[-1]]
        return ''.join(sorted(res))
