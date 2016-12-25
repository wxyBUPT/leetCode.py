#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

from collections import deque

'''
199. Binary Tree Right Side View   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 64112
Total Submissions: 166610
Difficulty: Medium
Contributors: Admin
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 使用队列应该执行效果更好一些
    # 52.93%
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        queue = deque([root])
        res = []
        while queue:
            size = len(queue)
            node = None
            for i in range(size):
                node = queue.popleft()
                if not node.left:
                    queue.append(node.left)
                if not node.right:
                    queue.append(node.right)
            res.append(node.val)
        return res

