#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com


'''
434. Number of Segments in a String   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 3431
Total Submissions: 8735
Difficulty: Easy
Contributors: love_FDU_llp
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
Subscribe to see which companies asked this question
'''

class Solution(object):
    def countSegments(self, s):
        """
        :type s: str
        :rtype: int
        """
        return len(s.split())