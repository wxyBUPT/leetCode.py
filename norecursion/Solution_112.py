#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
112. Path Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 136000
Total Submissions: 414813
Difficulty: Easy
Contributors: Admin
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 32.77%
    # 一般使用递归执行效率都不是很好
    # 使用二叉树的后序遍历的非递归方法
    # 非递归都放在norecursion中
    # 76.24%
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        stack = []
        curr = root
        SUM = 0
        pre = None
        while curr or stack:
            # 所有左节点入栈
            while curr:
                stack.append(curr)
                SUM += curr.val
                curr = curr.left

            curr = stack[-1]
            if not curr.left and not curr.right:
                if SUM == sum:
                    return True
            if curr.right and pre != curr.right:
                curr = curr.right
            else:
                pre = curr
                stack.pop()
                SUM -= curr.val
                curr = None
        return False
