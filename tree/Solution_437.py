#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
437. Path Sum III   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 9991
Total Submissions: 25908
Difficulty: Easy
Contributors: Stomach_ache
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):


    # 利用二叉树的后续遍历
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        return self.helper(root, 0, sum, [])

    def helper(self, node, curr, target, stack):
        res = 0
        if not node:
            return res
        stack.append(node.val)
        curr += curr+node.val

        if curr == target:
            res += 1

        tmp = curr
        for num in stack:
            tmp -= num
            if tmp == target:
                res += 1
        res += self.helper(node.left, target, curr, stack)
        res += self.helper(node.right, target, curr, stack)
        stack.pop()
        return res
