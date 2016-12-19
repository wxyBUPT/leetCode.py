#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
337. House Robber III   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 31723
Total Submissions: 76894
Difficulty: Medium
Contributors: Admin
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \
 1   3   1

'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 下面这种算法基本上是超时的
    # 这种算法其实强制的使用了时间换空间
    # 这种算法比较“粗糙”，没有根据“业务”写
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        rob_root = root.val
        if root.left:
            rob_root = rob_root + self.rob(root.left.left) + self.rob(root.left.right)
        if root.right:
            rob_root = rob_root + self.rob(root.right.left) + self.rob(root.right.right)
        left = self.rob(root.left)
        right = self.rob(root.right)
        return max(rob_root, left+right)

    # 同样超时
    # 进一步想想，使用到cache的场景只有说对于rob root 和disrob root 的场景
    def rob1(self, root):
        cache = {}
        return self.rob_with_cache(root, cache)

    def rob_with_cache(self, root, cache):

        if not root:
            return 0
        res = cache.get(root, -1)
        if res != -1:
            return res

        rob_root = root.val
        if root.left:
            rob_root = rob_root + self.rob(root.left.left) + self.rob(root.left.right)
        if root.right:
            rob_root = rob_root + self.rob(root.right.left) + self.rob(root.right.right)
        left = self.rob(root.left)
        if root.left:
            cache[root.left] = left
        right = self.rob(root.right)
        if root.right:
            cache[root.right] = right
        val = max(rob_root, left+right)
        cache[root] = val
        return val

    # 相当于使用cache
    # 其实想想之前的rob也可以优化
    # 27.40%
    def ans(self, root):
        def dfs(node):
            if not node:
                return [0,0]
            left, right = dfs(node.left), dfs(node.right)
            return [node.val + left[1] + right[1], max(left[0]+right[0], left[0] + right[1],
                                                       left[1] + right[0], left[1] + right[1]
                                                       )]
        return max(dfs(root))
