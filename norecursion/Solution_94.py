#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''

94. Binary Tree Inorder Traversal   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 166708
Total Submissions: 383468
Difficulty: Medium
Contributors: Admin
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
'''

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    # 52.66%
    def inorderTraversal(self, root):
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
                node = node.left
            node = stack.pop()
            res.append(node.val)
            node = node.right
        return res

    # 8.98%
    def inorderTraversal(self, root):
        res = []
        self.recurisive(root, res)
        return res

    def recurisive(self, root, res):
        if not root:
            return
        self.recurisive(root.left, res)
        res.append(root.val)
        self.recurisive(root.right, res)


if __name__ == "__main__":
    sl = Solution()
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)
    sl.inorderTraversal(root)

