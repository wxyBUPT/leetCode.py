#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

# 使用bfs解决层序遍历的问题


'''
102. Binary Tree Level Order Traversal   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 141337
Total Submissions: 386444
Difficulty: Easy
Contributors: Admin
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
'''

# # Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        self.dfs(root, res, 0)
        return res

    def dfs(self, root, res, level):
        if not root:
            return
        if level == len(res):
            res.append([])
        res[level].append(root.val)
        self.dfs(root.left, res, level + 1)
        self.dfs(root.right, res, level + 1)
