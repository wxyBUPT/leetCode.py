#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
413. Arithmetic Slices   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 8564
Total Submissions: 15764
Difficulty: Medium
Contributors: XiangyuLi926
A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
'''

class Solution(object):

    # 58.34%
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        len_A = len(A)
        if len_A < 3:
            return 0
        pre = 0
        n = 0
        for i in range(2,len_A):
            if A[i] - A[i-1] == A[i-1] - A[i-2]:
                n += 1
            else:
                n = 0
            pre = pre + n
        return pre
