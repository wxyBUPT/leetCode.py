#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import collections

'''

350. Intersection of Two Arrays II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 45002
Total Submissions: 103862
Difficulty: Easy
Contributors: Admin
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
'''

# 本题目同样有很多的解决办法

class Solution(object):

    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        a, b = map(collections.Counter, (nums1, nums2))
        return list((a & b).elements())

    def intersect2(self, nums1, nums2):

        nums1.sort()
        nums2.sort()

        i = 0
        j = 0
        len_1 = len(nums1)
        len_2 = len(nums2)
        res = []
        while i < len_1 and j < len_2:
            if nums1[i] < nums2[j]:
                i += 1
            elif nums2[j] < nums1[i]:
                j += 1
            else:
                res.append(nums1[i])
                i += 1
                j += 1
        return res
