#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
334. Increasing Triplet Subsequence   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 30147
Total Submissions: 80174
Difficulty: Medium
Contributors: Admin
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
'''


class Solution(object):

    # 48.96%
    # 在正太区间内
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        min_p = 0
        mid_p = -1
        for i in range(1,len(nums)):
            # 还没有第二大的点
            if mid_p == -1:
                if nums[i]>nums[min_p]:
                    mid_p = i
                if nums[i]<nums[min_p]:
                    min_p=i
                continue
            else:
                if nums[i]>nums[mid_p]:
                    return True
                if nums[i]<=nums[min_p]:
                    min_p=i
                    continue
                else:
                    mid_p = i
        return False




