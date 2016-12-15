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

    # 层序遍历，单是否对称
    # 相当于bfs，本题目同样有dfs版本，在dfs目录中
    # 76.95%
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        if root.left and root.right:
            level = [root.left, root.right]
        else:
            if bool(root.right) != bool(root.left):
                return False
            else:
                return True
        while level:
            l_len = len(level)
            if l_len % 2 ==1:
                return False
            # 判断这层是不是对称的
            for i in range(0, l_len/2):
                if level[i].val != level[l_len - i -1].val:
                    return False
                # 判断位置是不是对称的
                if bool(level[i].left) != bool(level[l_len - i - 1].right) or bool(level[i].right) != bool(level[l_len - i - 1].left):
                    return False
            l_level = []
            for i in range(l_len):
                node = level[i]
                if node.left:
                    l_level.append(node.left)
                if node.right:
                    l_level.append(node.right)
            level = l_level
        return True

