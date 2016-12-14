#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import math

'''
459. Repeated Substring Pattern   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 8584
Total Submissions: 21611
Difficulty: Easy
Contributors: YuhanXu
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

'''

class Solution(object):

    # 21.8 %
    def repeatedSubstringPattern(self, str):
        """
        :type str: str
        :rtype: bool
        """
        size = len(str)
        divisors = self.getDivisors(size)
        for divisor in divisors:
            count = size / divisor
            can = True
            for i in range(1, count):
                for j in range(divisor):
                    if str[j] != str[i * divisor + j]:
                        can = False
                        break
                if not can:
                    break

            if can:
                return True
        return False

    def getDivisors(self, size):
        res = []
        end = size / 2 + 1
        for i in range(1, end):
            if size % i == 0:
                res.append(i)
        return res

    # 92.26%
    def rsrs3(self, str):
        return str in (str * 2)[1:-1]

if __name__ == "__main__":
    sl = Solution()
    print sl.repeatedSubstringPattern("abab")

