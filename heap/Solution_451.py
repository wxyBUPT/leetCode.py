#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import collections
import heapq

'''
451. Sort Characters By Frequency   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 11198
Total Submissions: 22068
Difficulty: Medium
Contributors: stickypens
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
'''

class Solution(object):
    # 第一种方法使用桶排序
    # 4.33%
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        count=collections.Counter(s)
        bucket = [[] for _ in range(len(s)+1)]
        for key in count:
            bucket[count.get(key)].append(key)
        res = []
        for i in range(len(s),-1,-1):
            if bucket[i]:
                for c in bucket[i]:
                    for j in range(i):
                        res.append(c)
        return ''.join(res)

    # 第二种方法使用堆排序
    # 25.46%
    def frequencySort(self, s):
        count = collections.Counter(s)
        heap = []
        for c in count:
            heap.append((-count.get(c), c))
        heapq.heapify(heap)
        res = []
        while heap:
            count, c = heapq.heappop(heap)
            for i in range(count):
                res.append(c)
        return ''.join(res)




