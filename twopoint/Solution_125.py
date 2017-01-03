#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import string
'''
125. Valid Palindrome   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 135300
Total Submissions: 535713
Difficulty: Easy
Contributors: Admin
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
'''

class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        upper = set(string.uppercase)
        s.upper()
        i = 0
        j=len(s)-1
        while i<j:
            while i<j and s[i] not in upper:
                i += 1
            while i<j and s[j] not in upper:
                j -= 1
            if s[i] != s[j]:
                return False
            i+=1
            j-=1
        return True
