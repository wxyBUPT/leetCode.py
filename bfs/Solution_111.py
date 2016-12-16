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

    # 如果使用java，那么不用创建那么多的队列，只创建一个队列，然后每回用size记录对应的层数
    # 70.66%
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        res = 0
        level = [root]
        while level:
            res += 1
            tmp = []
            l_len = len(level)
            for i in range(l_len):
                node = level[i]
                if not node.left and not node.right:
                    return res
                if node.left:
                    tmp.append(node.left)
                if node.right:
                    tmp.append(node.right)
            level = tmp
        # 下面这句应该不会使用到
        return res


