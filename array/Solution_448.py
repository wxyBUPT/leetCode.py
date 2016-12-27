#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''
448. Find All Numbers Disappeared in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 11594
Total Submissions: 19911
Difficulty: Easy
Contributors: yuhaowang001
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
'''

class Solution(object):

    # 出现的位置变为负值
    # 击败0%的代码
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for num in nums:
            index = abs(num) - 1
            if nums[index] > 0:
                nums[index] = - nums[index]

        res = []
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res

    # 252ms 击败了 0%的选手
    def find(self, nums):
        tmp = [0 for _ in range(len(nums))]
        for num in nums:
            tmp[num-1]=1
        res = []
        for i in range(len(tmp)):
            if tmp[i]==0:
                res.append(i+1)
        return res
