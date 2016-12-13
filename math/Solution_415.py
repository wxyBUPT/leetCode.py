#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
415. Add Strings   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 15206
Total Submissions: 36755
Difficulty: Easy
Contributors: Admin
Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
'''

class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        carry = 0
        res = ''
        i = len(num1) - 1
        j = len(num2) - 1
        while i >= 0 and j >= 0:
            c_sum = carry + ord(num1[i]) + ord(num2[j]) - 96
            carry = c_sum / 10
            value = c_sum % 10
            res = str(value) + res
            i -= 1
            j -= 1
        while i>= 0:
            c_sum = carry + ord(num1[i]) - 48
            carry = c_sum / 10
            res = str(c_sum%10) + res
            i -= 1

        while j>=0:
            c_sum = carry + ord(num2[j]) - 48
            carry = c_sum /10
            res = str(c_sum % 10) + res
            j -= 1

        if carry:
            res = '1' + res
        return res

if __name__ == "__main__":
    sl = Solution()
    print sl.addStrings("111", "111")
