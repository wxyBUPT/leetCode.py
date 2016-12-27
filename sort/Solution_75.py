#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
75. Sort Colors   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 133588
Total Submissions: 365262
Difficulty: Medium
Contributors: Admin
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.
'''

class Solution(object):

    # 44.10%
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        red = 0
        blue = len(nums)-1
        i=0
        while i<=blue:
            while nums[i]==2 and i<blue:
                nums[i],nums[blue]=nums[blue], nums[i]
                blue-=1
            while nums[i]==0 and i>red:
                nums[i],nums[red]=nums[red],nums[i]
                red+=1
            i+=1

    # 62.03
    # 两种方法各有各的好，针对不同的场景
    # 这种方法赋值多一点
    def bad(self, nums):
        red = 0
        white = 0
        blue = 0
        for num in nums:
            if num == 0:
                red += 1
            elif num == 1:
                white += 1
            else:
                blue+=1
        for i in range(red):
            nums[i] = 0
        for i in range(red,red+white):
            nums[i]=1
        for i in range(red+white,red+blue+white):
            nums[i]=2
