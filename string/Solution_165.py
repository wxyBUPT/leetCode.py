#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import itertools

'''
165. Compare Version Numbers   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 73464
Total Submissions: 384514
Difficulty: Easy
Contributors: Admin
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
'''

class Solution(object):

    # 34.65%
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        v1 = version1.split('.')
        v2 = version2.split('.')
        while len(v1) < len(v2):
            v1.append('0')
        while len(v2) < len(v1):
            v2.append('0')
        n_len = len(v2)
        for i in range(n_len):
            diff = int(v1[i]) - int(v2[i])
            if diff:
                return 1 if diff > 0 else -1
        return 0

    def stefanPochmannn(self, version1, version2):
        v1, v2 = (map(int, v.split('.')) for v in (version1, version2))
        d = len(v1) - len(v2)
        return cmp(v1 + -d * [0], v2 + d * [0])


