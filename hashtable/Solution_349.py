#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
349. Intersection of Two Arrays   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 63339
Total Submissions: 139684
Difficulty: Easy
Contributors: Admin
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
'''

class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        return list(set(nums1) & set(nums2))

    def intersection2(self, nums1, nums2):

        nums1.sort()
        nums2.sort()
        i = 0
        j = 0
        nums1_len = len(nums1)
        nums2_len = len(nums2)
        res = set()
        while i < nums1_len and j<nums2_len:
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] >  nums2[j]:
                j += 1
            else:
                res.add(nums2[j])
                i += 1
                j += 1
        return list(res)


