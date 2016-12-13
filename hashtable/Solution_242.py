#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import collections


'''
242. Valid Anagram   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 125500
Total Submissions: 281560
Difficulty: Easy
Contributors: Admin
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
'''

class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        s_c = collections.Counter(s)
        s_t = collections.Counter(t)
        return s_c == s_t

    def isAnagram(self, s, t):
        c_hash = [0] * 26
        for c in s:
            c_hash[ord(c) - 97] += 1

        for c in t:
            c_hash[ord(c) - 97] -= 1

        for i in c_hash:
            if i != 0:
                return False
        return True
