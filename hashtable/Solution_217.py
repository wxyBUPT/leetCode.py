#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
217. Contains Duplicate   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 130810
Total Submissions: 301440
Difficulty: Easy
Contributors: Admin
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.
'''

# 其实本题目的算法有很多
class Solution(object):

    # beats 90% + 但是觉得不是最优的，所以运行时间完全看运气，并且对python的内部执行机制也没有java 熟悉
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        return len(nums) != len(set(nums))

    def containsDuplicate2(self, nums):
        nums.sort()
        nums_len = len(nums)
        for i in range(1, nums_len):
            if nums[i] == nums[i-1]:
                return True
        return False

    def containsDuplicate3(self, nums):
        existes = set()
        for num in nums:
            if num in existes:
                return True
            existes.add(num)
        return False
