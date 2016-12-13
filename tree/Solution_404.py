#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
404. Sum of Left Leaves   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 24874
Total Submissions: 54615
Difficulty: Easy
Contributors: Admin
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 下面是中规中矩的算法
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.dfs(root, False)

    def dfs(self, root, isLeft):

        if root == None:
            return 0

        if not root.left and not root.right and isLeft:
            return root.val

        return self.dfs(root.left, True) + self.dfs(root.right, False)

    def sumOfLeftLeaves(self, root):

        if not root:
            return 0

        s = [root]
        res = 0
        while s:
            curr = s.pop()
            if curr.left:
                s.append(curr.left)
                if not curr.left.left and not curr.left.right:
                    res += curr.left.val
            if curr.right:
                s.append(curr.right)
        return res



