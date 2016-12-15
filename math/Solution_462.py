#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
462. Minimum Moves to Equal Array Elements II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 4441
Total Submissions: 8825
Difficulty: Medium
Contributors: andrew56
Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
'''

class Solution(object):

    def minMoves2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        return sum(nums[~i] - nums[i] for i in range(len(nums) / 2))

