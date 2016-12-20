#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
198. House Robber   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 107373
Total Submissions: 288877
Difficulty: Easy
Contributors: Admin
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

'''

class Solution(object):

    # 66.25%
    def totolipton(self, nums):
        '''
        f(0) = nums[0]
        f(1) = nums[1]
        f(k) = max(f(k-2) + nums[k] , f(k-1))
        :param nums: List[int]
        :return:
        '''

        last, now = 0, 0
        for i in nums:
            last, now = now, max(last + i, now)
        return now

    # 早晨没有睡醒自己想的垃圾算法，没有参考价值
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        nums_len = len(nums)
        if nums_len == 1:
            return nums[0]
        if nums_len == 2:
            return max(nums)
        rob = [0] * (nums_len + 1)
        dis_rob = [0] * (nums_len + 1)
        rob[1] = nums[0]
        rob[2] = nums[1]
        dis_rob[2] = nums[0]
        for i in range(3, nums_len + 1):
            rob[i] = nums[i-1] + max(dis_rob[i-1], rob[i-3])
            dis_rob[i] = max(rob[i-1], rob[i-2])
        return max(dis_rob[nums_len], rob[nums_len])

