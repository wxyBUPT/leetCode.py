#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import operator
import collections

'''
389. Find the Difference   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 40604
Total Submissions: 80883
Difficulty: Easy
Contributors: Admin
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
'''

class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        return chr(reduce(operator.xor, map(ord, s + t)))


    def findTheDifference(self, s, t):
        return list(collections.Counter(s) - collections.Counter(t))[0]

    def findTheDifference(self, s, t):
        return chr(sum(map(ord, t)) - sum(map(ord, s)))