#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''
318. Maximum Product of Word Lengths   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 39851
Total Submissions: 95128
Difficulty: Medium
Contributors: Admin
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
'''

class Solution(object):

    # 有关bit的操作建议使用java
    # 59.50%
    # 但是分布好像不是最好的算法
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        MASK = 0xFFFFFFFF
        words_len = len(words)
        words_hash = [0] * words_len
        for i in range(words_len):
            word = words[i]
            for c in word:
                words_hash[i] |= 1 << (ord(c) - 97)
            words_hash[i] &= MASK
        maxPro = 0
        cache = [len(word) for word in words]
        for i in range(words_len):
            for j in range(i+1, words_len):
                if words_hash[i] & words_hash[j] == 0:
                    maxPro = max(maxPro, cache[i] * cache[j])
        return maxPro

    # 其实还能进一步的空间换时间
    # 84.07%
    def agave(self, words):
        d = {}
        for w in words:
            mask = 0
            for c in w:
                mask |= 1 << (ord(c) - 97)
            d[mask] = max(d.get(mask, 0), len(w))
        return max([d[x] * d[y] for x in d for y in d if not x & y] or [0])


