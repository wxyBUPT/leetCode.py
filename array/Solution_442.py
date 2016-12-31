#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''

442. Find All Duplicates in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 8492
Total Submissions: 18148
Difficulty: Medium
Contributors: shen5630
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
'''

class Solution(object):

    # 31.90%
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        for num in nums:
            index = abs(num)-1
            if nums[index]<0:
                res.append(abs(num))
            nums[index] = -nums[index]
        return res

