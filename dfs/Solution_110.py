#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
110. Balanced Binary Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 146107
Total Submissions: 405477
Difficulty: Easy
Contributors: Admin
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 66%
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        _, balance = self.isBalancedWithDepth(root)
        return balance

    def isBalancedWithDepth(self, root):
        if not root:
            return 0, True

        left_depth, left_balance = self.isBalancedWithDepth(root.left)
        if not left_balance:
            return 0, False

        right_depth, right_balance = self.isBalancedWithDepth(root.right)
        if not  right_balance:
            return 0, False

        if abs(left_depth - right_depth) > 1:
            return 0, False

        else:
            return 1 + max(right_depth, left_depth), True

'''
对于不能返回两个值的编程语言，可以使用数据结构，或者使用-1来代表已经不能成为平衡二叉树
'''
