#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
283. Move Zeroes   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 140917
Total Submissions: 297298
Difficulty: Easy
Contributors: Admin
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
'''

class Solution(object):

    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = 0
        nums_len = len(nums)
        while i < nums_len:
            if nums[i] == 0:
                i += 1
            else:
                nums[j] = nums[i]
                i += 1
                j += 1
        while j < nums_len:
            nums[j] = 0
            j += 1

    def moveZeroes2(self, nums):

        index = 0
        for num in nums:
            if num != 0:
                nums[index] = num
                index += 1
        nums_len = len(nums)
        while index < nums_len:
            nums[index] = 0
            index += 1

