#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import bisect
'''
436. Find Right Interval   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 4633
Total Submissions: 11015
Difficulty: Medium
Contributors: love_FDU_llp
Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
'''

# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

# 第一眼看到本题目想到使用java 的treemap
# 或者使用java的二分查找
class Solution(object):

    def stefanPochmann(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[int]
        """
        starts = sorted([[I.start, i] for i, I in enumerate(intervals)]) + [[float('inf'), -1]]
        return [starts[bisect.bisect(starts, [I.end])][1] for I in intervals]

    def findRightInterval(self, intervals):
        def bisect(vals, target):
            i = 0
            j = len(vals)
            while i<j:
                mid = i + (j - i)/2
                if vals[mid] > target:
                    j = mid
                else:
                    i = mid + 1
            return i
        starts = sorted([[I.start, i] for i,I in enumerate(intervals)]) + [[float('inf'), -1]]
        return [starts[bisect(starts, [I.end])][1] for I in intervals]




if __name__ == "__main__":
    sl = Solution()
    print sl.findRightInterval([[1,2]])

