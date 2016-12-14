#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
102. Binary Tree Level Order Traversal   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 141336
Total Submissions: 386443
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

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 62.86
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        level = []
        if root:
            level.append(root)
        while level:
            res.append([node.val for node in level])
            l_len = len(level)
            tmp = []
            for i in range(l_len):
                node = level[i]
                if node.left:
                    tmp.append(node.left)
                if node.right:
                    tmp.append(node.right)
            level = tmp

        return res

# 本题目与bfs的另外一个题目比较类似

