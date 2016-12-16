#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
257. Binary Tree Paths   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 81508
Total Submissions: 237950
Difficulty: Easy
Contributors: Admin
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    # 使用非递归的后续遍历
    # @param {TreeNode} root
    # @return {string[]}
    # 20.86% 为为改进前的执行结果，即只是用一个栈
    # 改进后同样的节点不用多次转化，所以执行时间有明显的提升
    # 69.17%
    def binaryTreePaths1(self, root):
        res = []
        stack = []
        path = []
        curr = root
        pre = None
        while curr or stack:
            while curr:
                stack.append(curr)
                path.append(str(curr.val))
                curr = curr.left
            curr = stack[-1]
            if not curr.left and not curr.right:
                res.append("->".join(path))
            if curr.right and curr.right != pre:
                curr = curr.right
            else:
                pre = curr
                stack.pop()
                path.pop()
                curr = None
        return res

    # 下面是使用递归的方法
    # 55.7%(这也能！！！！)
    def binaryTreePaths(self, root):
        ans = []
        if not root:
            return ans
        self.dfs(root, '', ans)
        return ans

    def dfs(self, root, path, ans):
        path = path + str(root.val)
        if not root.left and not root.right:
            ans.append(path)
        if root.left:
            self.dfs(root.left, path + "->", ans)
        if root.right:
            self.dfs(root.right, path + "->", ans)

def useappend(nums):
    res = ''
    for num in nums:
        res += str(num)
        res += '->'
    return res

if __name__ == "__main__":
    import time
    a = range(1000)
    start = time.time()
    # 执行1000次
    for i in range(10000):
        '->'.join(str(i) for i in a)
    end = time.time()
    print u"使用join工花费了%f" % (end - start)

    start = time.time()
    for i in range(10000):
        useappend(a)
    end = time.time()
    print u'使用字符串拼接花费了%fA ' % (end - start)





