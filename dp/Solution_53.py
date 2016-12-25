#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
53. Maximum Subarray   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 155314
Total Submissions: 402185
Difficulty: Medium
Contributors: Admin
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.
'''

class Solution(object):

    # 33.86%
    # 本题目的分制算法时间复杂度比较高
    def maxSubArray(self, nums):
        res = float('-inf')
        maxValueWithMid = 0
        for i in range(len(nums)):
            res = max(res,maxValueWithMid+nums[i])
            maxValueWithMid = max(0, maxValueWithMid+nums[i])
        return res



    # 33.86%
    def maxSubArrayBad(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums_len = len(nums)
        dp_max = [0] * (nums_len+1)
        dp_edge = [0] * (nums_len+1)
        dp_max[1] = nums[0]
        dp_edge[1] = nums[0]
        for i in range(2, 1+nums_len):
            dp_edge[i] = nums[i-1] if dp_edge[i-1] < 0 else dp_edge[i-1] + nums[i-1]
            dp_max[i] = max(dp_max[i-1], dp_edge[i])
        return max(dp_edge[nums_len], dp_max[nums_len])
