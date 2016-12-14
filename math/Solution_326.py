#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
326. Power of Three   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 75694
Total Submissions: 193667
Difficulty: Easy
Contributors: Admin
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

'''


class Solution(object):
    def isPowerOfThree(self, n):
        return n > 0 and 1162261467 % n == 0