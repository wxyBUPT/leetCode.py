#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''

111. Minimum Depth of Binary Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 140192
Total Submissions: 436392
Difficulty: Easy
Contributors: Admin
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 4.98%,基本上处于下游位置了
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        if not root.left and not root.right:
            return 1

        if not root.left:
            return 1 + self.minDepth(root.right)
        if not root.right:
            return 1 + self.minDepth(root.left)
        return 1 + min(self.minDepth(root.right), self.minDepth(root.left))

