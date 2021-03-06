#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
235. Lowest Common Ancestor of a Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 108743
Total Submissions: 286545
Difficulty: Easy
Contributors: Admin
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 21%
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        res = root
        p_v = p.val
        q_v = q.val
        while  (res.val < p_v and res.val < q_v) or (res.val>p_v and res.val > q_v):
            if res.val < p_v:
                res = res.right
            else:
                res = res.left
        return res

    def stefanPochmann(self, root, p, q):
        while (root.val - p.val) * (root.val - q.val) > 0 :
            root = (root.left, root.right)[p.varl > root.val]
        return root

