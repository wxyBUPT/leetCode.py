#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import collections
import string

'''
383. Ransom Note   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 33012
Total Submissions: 72097
Difficulty: Easy
Contributors: Admin
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
'''

class Solution(object):

    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        return not collections.Counter(ransomNote) - collections.Counter(magazine)

    def canConstruct(self, ransomNote, magazine):
        return all(ransomNote.count(i) <= magazine.count(i) for i in string.ascii_lowercase)