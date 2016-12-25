#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
173. Binary Search Tree Iterator   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 72214
Total Submissions: 186544
Difficulty: Medium
Contributors: Admin
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

'''

# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# 77.41%
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.node = root
        self.stack = []

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.node or self.stack

    def next(self):
        """
        :rtype: int
        """
        node = self.node
        stack = self.stack

        while node:
            stack.append(node)
            node = node.left
        node = stack.pop()
        val = node.val
        self.node = node.right
        return val

def inorder(root):
    stack = []
    node = root
    res = []
    while node or stack:
        while node:
            stack.append(node)
            node = node.left
        node = stack.pop()
        res.append(node.val)
        node = node.right





# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())