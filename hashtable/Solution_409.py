#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

import collections

'''
409. Longest Palindrome   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 18759
Total Submissions: 42611
Difficulty: Easy
Contributors: Admin
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
'''

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        odds = sum(v & 1 for v in collections.Counter(s).values())
        return len(s) - odds + bool(odds)