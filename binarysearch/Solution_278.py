#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
278. First Bad Version   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 75375
Total Submissions: 311901
Difficulty: Easy
Contributors: Admin
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
'''


# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

def isBadVersion(version):
    return True

class Solution(object):

    # 61.74%
    # 但是好像不是最优的
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        start = 1
        end = n
        # 找前面
        while start < end:
            mid = start + (end - start) / 2
            # 找到了
            if isBadVersion(mid):
                if mid >1 and isBadVersion(mid-1):
                    end = mid - 1
                    continue
                else:
                    return mid
            else:
                start = mid + 1
        return start

    # 61.74%
    def firstBadVersion1(self, n):
        i = 1
        j = n
        while i<j:
            mid = i + (j - i)/2
            if not isBadVersion(mid):
                i = mid + 1
            else:
                j = mid
        return i


