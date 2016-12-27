#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
390. Elimination Game   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 5905
Total Submissions: 15676
Difficulty: Medium
Contributors: Admin
There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

Find the last number that remains starting with a list of length n.

Example:

Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

Output:
6
'''

class Solution(object):

    # 48.68%
    def lastRemaining(self, n):
        """
        :type n: int
        :rtype: int
        """
        increment = 1
        start = 1
        l_r = True
        while n:
            if n == 1:
                return start
            if n==2:
                if l_r:
                    return start+increment
                else:
                    return start
            # 如果n是偶数,那么start不会改变
            # 剩余的情况，start 都是下一个位置
            if l_r or n%2==1:
                start += increment
            l_r = not l_r
            n/=2
            increment *= 2


