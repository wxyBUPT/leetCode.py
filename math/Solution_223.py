#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
223. Rectangle Area   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 53548
Total Submissions: 168680
Difficulty: Easy
Contributors: Admin
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
'''

class Solution(object):

    # 58.11%
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        left = max(A,E)
        right = max(left, min(C, G))
        bottom = max(B, F)
        top = max(bottom, min(H, D))
        return (C-A) * (D-B) - (right - left) * (top - bottom) + (G - E) * (H - F)

