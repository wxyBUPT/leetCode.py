#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''
421. Maximum XOR of Two Numbers in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 5444
Total Submissions: 13417
Difficulty: Medium
Contributors: shen5630
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
'''

# 如果不看提示很难想到用字典树解决问题
# 字典树算是自己写代码比较少的部分

class Tire:

    def __init__(self):
        self.childern = [None] * 2

class Solution(object):

    # 简直就是神奇
    def findMaximumXOR(self, nums):
        ans = 0
        for i in range(32)[::-1]:
            ans <<= 1
            prefixs = {num >> i for num in nums}
            ans += any(ans^p^1 in prefixs for p in prefixs)
        return ans


    # 72.86%
    # 通过位操作理解本题的思路，如果不是很理解，体会下字典树然后
    def stefanPochmann(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        answer = 0
        for i in range(32)[::-1]:
            answer <<= 1
            prefixs = {num >> i for num in nums}
            answer += any(answer^1^p in prefixs for p in prefixs)
        return answer

    # 0.60%
    # 不敢相信！总之是远离正太分布的,并且多提交就会超时
    def findMaximumXORExceptionallyBad(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        root = Tire()
        if not nums:
            return 0
        # 为每一个字母创建字典树
        for num in nums:
            curr = root
            for i in range(31, -1 , -1):
                bit = (num >> i) & 1
                if not curr.childern[bit]:
                    curr.childern[bit] = Tire()
                curr = curr.childern[bit]
        res = float('-inf')
        # 创建字典树之后也不是树高的时间复杂度，需要看每一个数字是否有与其组合的
        for num in nums:
            curr = root
            currSum = 0
            for i in range(31, -1, -1):
                bit = (num >> i) & 1
                if curr.childern[bit^1]:
                    # 当前bit有与之相加为1的
                    currSum += (1<<i)
                    curr = curr.childern[bit^1]
                else:
                    curr = curr.childern[bit]
            res = max(res, currSum)
        return res





