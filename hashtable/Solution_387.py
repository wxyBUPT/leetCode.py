#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import string

'''
387. First Unique Character in a String   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 33077
Total Submissions: 73407
Difficulty: Easy
Contributors: Admin
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
'''

class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = []
        for c in string.lowercase:
            i = s.find(c)
            j = s.rfind(c)
            if i != -1 and i == j:
                res.append(i)
        return min(res) if res else -1

