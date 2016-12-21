#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

import collections
'''

 454. 4Sum II

    Total Accepted: 3866
    Total Submissions: 9403
    Difficulty: Medium
    Contributors: Samuri

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
'''

class Solution(object):

    # 8.32%
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """
        dict_1 = {}
        dict_2 = {}
        for a in A:
            for b in B:
                key = a + b
                dict_1[key] = dict_1.get(key,0) + 1
        for c in C:
            for d in D:
                key = c + d
                dict_2[key] = dict_2.get(key, 0) + 1

        res = 0
        for i in dict_1:
            res += dict_2.get(-i, 0) * dict_1[i]
        return res

    # 3.70%
    # 强行算了一波乘法
    def forSumCountImporved(self, A, B, C, D):
        dict_1 = collections.Counter(a+b for a in A for b in B)
        dict_2 = collections.Counter(c+d for c in C for d in D)

        res = 0
        for i in dict_1:
            res += dict_2.get(-i, 0) * dict_1[i]
        return res

    # 16.86%
    def stefanPochmann(self, A, B, C, D):
        AB = collections.Counter(a+b for a in A for b in B)
        return sum(AB[-c-d] for c in C for d in D)

