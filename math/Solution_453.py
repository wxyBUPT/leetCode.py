#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
453. Minimum Moves to Equal Array Elements   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 8746
Total Submissions: 19106
Difficulty: Easy
Contributors: amehrotra2610
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
'''

# 每次对 n-1 个数增加相当于 对一个数减少

class Solution(object):

    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return sum(nums) - len(nums) * min(nums)
