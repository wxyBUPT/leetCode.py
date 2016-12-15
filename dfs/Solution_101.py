#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
101. Symmetric Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 145171
Total Submissions: 395902
Difficulty: Easy
Contributors: Admin
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 深度优先遍历
    # 19.89% - 30%
    # 使用层序遍历击败了 76.95%
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return not root or self.dfs(root.left, root.right)

    def dfs(self, left, right):
        if not left or not right:
            return left is right
        if left.val != right.val:
            return False
        return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)

