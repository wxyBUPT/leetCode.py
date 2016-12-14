#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
66. Plus One   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 139271
Total Submissions: 380334
Difficulty: Easy
Contributors: Admin
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
'''

class Solution(object):

    # 12.15% 这种方法使用与数的加法，但是对应于本题，过于笨拙
    # 下面是比较适合本题目的解法
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        carry = 1
        d_i = len(digits) - 1
        while d_i >= 0:
            sum = digits[d_i] + carry
            digits[d_i] = sum % 10
            carry = sum / 10
            d_i -= 1

        if carry:
            digits.insert(0,carry)
        return digits

    # 61.75%
    def plusOne1(self, digits):

        d_i = len(digits) - 1
        while d_i >= 0:
            if digits[d_i] < 9 :
                digits[d_i] += 1
                return digits
            digits[d_i] = 0
            d_i -= 1

        digits.insert(0, 1)
        return digits
