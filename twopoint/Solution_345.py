#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
345. Reverse Vowels of a String   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 56654
Total Submissions: 152933
Difficulty: Easy
Contributors: Admin
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

'''


class Solution(object):
    vowels = set('aeiouAEIOU')

    #93.30%
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """

        i = 0
        j = len(s) - 1
        s = list(s)

        # 其实下面的循环可以简化为一个循环
        while i < j:
            while i<j and s[i] not in self.vowels :
                i += 1
            while i<j and s[j] not in self.vowels :
                j -= 1
            if i < j :
                tmp = s[i]
                s[i] = s[j]
                s[j] = tmp
                i += 1
                j -= 1
        return ''.join(s)

    # 93.97%
    def reverseVowels2(self, s):

        i = 0
        j = len(s) - 1
        s = list(s)
        while i < j:
            if s[i] not in self.vowels:
                i += 1
            if s[j] not in self.vowels:
                j -= 1
            if s[i] in self.vowels and s[j] in self.vowels:
                s[i], s[j] = s[j], s[i]
                i += 1
                j -= 1
        return ''.join(s)


if __name__ == "__main__":
    sl = Solution()
    print sl.reverseVowels('leetcode')

