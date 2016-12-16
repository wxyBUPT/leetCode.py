#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
238. Product of Array Except Self   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 74644
Total Submissions: 159837
Difficulty: Medium
Contributors: Admin
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

Subscribe to see which companies asked this question

Hide Tags Array
Show Similar Problems
'''

class Solution(object):

    # 40.83%
    # 虽然想到了这种方法，但是方法本身占用了额外的空间
    def productExceptSelfBad(self, nums):
        """
        tu:type nums: List[int]
        :rtype: List[int]
        """
        nums_len = len(nums)
        l_to_r = [0] * nums_len
        l_to_r[0] = nums[0]
        r_to_l = [0] * nums_len
        r_to_l[nums_len - 1] = nums[nums_len - 1]
        for i in range(1, nums_len):
            l_to_r[i] = nums[i] * l_to_r[i-1]
            r_to_l[nums_len - i - 1] = nums[nums_len - i - 1] * r_to_l[nums_len - i]
        res = [0] * nums_len
        res[0] = r_to_l[1]
        res[nums_len - 1] = l_to_r[nums_len - 2]
        for i in range(1,nums_len - 1):
            res[i] = l_to_r[i-1] * r_to_l[i+1]
        return res

    # 87.87% 其实能够在50%左右就是大多数的想法了
    def productExceptSelf(self, nums):
        nums_len = len(nums)
        res = [0] * nums_len
        res[0] = nums[0]
        for i in range(1, nums_len):
            res[i] = nums[i] * res[i-1]
        right = 1
        for i in range(nums_len - 1, 0,-1):
            res[i] = res[i-1] * right
            right *= nums[i]
        res[0] = right
        return res

