#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
74. Search a 2D Matrix   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 104953
Total Submissions: 294791
Difficulty: Medium
Contributors: Admin
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
'''

class Solution(object):

    # 66.58%
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        start = 0
        end = len(matrix)
        while start < end:
            mid = (start+end)//2
            if matrix[mid][0]>target:
                end=mid
            else:
                start=mid+1
        row=matrix[start-1]
        i=0
        j=len(row)-1
        while i<=j:
            mid=i+(j-i)/2
            if row[mid]==target:
                return True
            elif row[mid]<target:
                i=mid+1
            else:
                j=mid-1
        return False

