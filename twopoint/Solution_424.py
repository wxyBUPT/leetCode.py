#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import string

'''
424. Longest Repeating Character Replacement   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 5287
Total Submissions: 13363
Difficulty: Medium
Contributors: Admin
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
'''

class Solution(object):

    # 99.51%
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        s_len = len(s)
        start = 0
        count = [0] * 26
        max_char_count = 0
        for end in range(s_len):
            index = ord(s[end]) - 65
            count[index] += 1
            max_char_count = max(max_char_count, count[index])
            if max_char_count+k<=end-start:
                count[ord(s[start])-65] -= 1
                start += 1
        return s_len - start

    # 98.28% 进一步提高是直接将字符串算成ord的形式
    def characterReplacementImproved(self, s, k):
        s_len = len(s)
        start = 0
        count = [0] * 128
        max_char_count = 0
        for end in range(s_len):
            count[ord(s[end])] += 1
            max_char_count = max(max_char_count, count[ord(s[end])])
            if max_char_count + k <= end - start:
                count[ord(s[start])] -= 1
                start += 1
        return s_len - start


    # 3.99% 肯定不是最优的算法
    # 算法不好的地方在于同样的事情做了26遍，可以借鉴上述的算法，用一个max值记录当前最大值
    def characterReplacementBad(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        def get_max(s, k, c):
            n = len(s)
            i = 0
            j = 0
            max_val = 0
            while j<n:
                while j < n and s[j] == c:
                    j += 1
                if k > 0 and j < n:
                    k -= 1
                    j += 1
                    continue
                max_val = max(max_val, j-i)
                while i < n and s[i] == c:
                    i += 1
                if i<n:
                    i += 1
                    k += 1
            return max(max_val, j-i)

        max_val = 0
        for c in string.uppercase:
            max_val = max(get_max(s, k, c), max_val)
        return max_val

def get_max(s, k, c):
    n = len(s)
    i = 0
    j = 0
    max_val = 0
    while j<n:
        while j < n and s[j] == c:
            j += 1
        if k > 0 and j < n:
            k -= 1
            j += 1
            continue

        max_val = max(max_val, j-i)
        while i < n and s[i] == c:
            i += 1
        if i<n:
            i += 1
            k += 1
    return max(max_val, j-i)

if __name__ == "__main__":
    print get_max("BAAAB", 2, 'A')


