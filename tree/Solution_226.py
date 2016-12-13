#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
226. Invert Binary Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 139448
Total Submissions: 282097
Difficulty: Easy
Contributors: Admin
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return None
        left = root.left
        right = root.right
        self.invertTree(left)
        self.invertTree(right)
        root.right = left
        root.left = right
        return root