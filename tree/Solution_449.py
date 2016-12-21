#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

from treeNode import TreeNode
'''
449. Serialize and Deserialize BST   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 2028
Total Submissions: 5067
Difficulty: Medium
Contributors: ben65
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.
'''

# 应该利用到前序遍历和中序遍历结果相同

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class CodecImproved:

    # 利用二叉搜索树的性质
    # 74.26%
    def serialize(self, root):
        def preorder(node, curr):
            if not node:
                return []
            curr.append(node.val)
            preorder(node.left, curr)
            preorder(node.right, curr)
        res = []
        preorder(root, res)
        return '#'.join([str(i) for i in res])

    def deserialize(self, data):

        if not data:
            return None

        def build(order, l, r):
            if l>=r:
                return None
            val = order[l]
            # 从order 中找到第一个比val大的点,如果找不到
            i = l+1
            while i<r and order[i]<val:
                i+=1
            node = TreeNode(val)
            node.left = build(order, l+1, i)
            node.right = build(order, i, r)
            return node

        order = map(int, data.split('#'))
        return build(order, 0, len(order))






# 利用前中序确定唯一的二叉树
# 但是只击败了 0.01%，被击败的选手有可能是我之前提交的代码
# 利用前序遍历和后续遍历没有利用到二叉搜索树的性质，只是用到了普通二叉树的性质
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return None
        def pre_order(root):
            node = root
            stack = []
            res = []
            while node or stack:
                while node:
                    res.append(str(node.val))
                    stack.append(node)
                    node = node.left
                node = stack.pop()
                node = node.right
            return res

        def in_order(root):
            node = root
            stack = []
            res = []
            while node or stack:
                while node:
                    stack.append(node)
                    node = node.left
                node = stack.pop()
                res.append(str(node.val))
                node = node.right
            return res

        return '\n'.join(['\t'.join(pre_order(root)), '\t'.join(in_order(root))])


    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        pre_order, in_order = [map(int, st_r.split('\t')) for st_r in data.split('\n')]
        def construct(pre, p_s, p_e, ino, i_s, i_e):
            if p_s > p_e:
                return None
            val = pre[p_s]
            root = TreeNode(val)
            i_i = ino.index(val)
            l_len = i_i - i_s
            root.left = construct(pre, p_s+1, p_s+l_len, ino, i_s, i_i-1)
            root.right = construct(pre, p_s+l_len+1, p_e, ino, i_i+1, i_e)
            return root
        return construct(pre_order, 0, len(pre_order)-1, in_order, 0, len(in_order)-1)


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))

root = TreeNode(4)
root.left = TreeNode(2)
root.right = TreeNode(6)
if __name__ == "__main__":
    codec = CodecImproved()
    data = codec.serialize(root)
    print data
    print codec.serialize(codec.deserialize(data))
