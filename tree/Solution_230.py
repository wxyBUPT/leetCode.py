#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
230. Kth Smallest Element in a BST   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 77345
Total Submissions: 185485
Difficulty: Medium
Contributors: Admin
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 二叉树非递归的中序遍历
    # 53.75%
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        stack = []
        node = root
        while node or stack:
            while node:
                stack.append(node)
                node = node.left
            # 出栈
            node = stack.pop()
            k -= 1
            if not k:
                return node.val
            node = node.right
