#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
27. Remove Element   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 161172
Total Submissions: 439790
Difficulty: Easy
Contributors: Admin
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Show Hint
'''

class Solution(object):

    # 81.83%
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """

        i = 0
        j = 0
        nums_len = len(nums)
        while j < nums_len:
            if nums[j] != val:
                nums[i] = nums[j]
                i += 1
            j += 1
        return i

