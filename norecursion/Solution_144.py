#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
144. Binary Tree Preorder Traversal   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 155084
Total Submissions: 362132
Difficulty: Medium
Contributors: Admin
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 59.01%
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        stack = []
        node = root
        res = []
        while node or stack:
            while node:
                stack.append(node)
                res.append(node.val)
                node = node.left
            node = stack.pop()
            node = node.right
        return res

    # 47.52%
    def preorderTraversal(self, root):
        res = []
        self.useRecursive(root, res)
        return res

    def useRecursive(self, root, res):
        if not root:
            return
        res.append(root.val)
        self.useRecursive(root.left, res)
        self.useRecursive(root.right, res)


