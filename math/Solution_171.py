#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
171. Excel Sheet Column Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 109916
Total Submissions: 244482
Difficulty: Easy
Contributors: Admin
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
'''

class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        return reduce(lambda x, y : x * 26 + y, [ord(c) - 64 for c in list(s)])
        

