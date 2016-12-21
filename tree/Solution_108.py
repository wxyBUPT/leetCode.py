#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
from tree.treeNode import TreeNode

'''
108. Convert Sorted Array to Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 99155
Total Submissions: 246722
Difficulty: Medium
Contributors: Admin
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 56.05%
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        return self.divideandconquer(nums, 0, len(nums))

    def divideandconquer(self, nums, i, j):
        if i<j:
            mid = (i+j)//2
            node = TreeNode(nums[mid])
            node.left = self.divideandconquer(nums, i, mid)
            node.right = self.divideandconquer(nums, mid+1, j)
            return node
        return None


