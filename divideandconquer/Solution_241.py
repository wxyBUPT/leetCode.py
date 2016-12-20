#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import operator
import re

'''
241. Different Ways to Add Parentheses   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 35457
Total Submissions: 86796
Difficulty: Medium
Contributors: Admin
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
'''


class Solution(object):

    # 69.58%
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        return self.divideandconquer(input, 0, len(input))

    def divideandconquer(self, input, start, end):
        all_digit = True
        res = []
        for i in range(start, end):
            if input[i] == '+':
                left = self.divideandconquer(input,start,i)
                right = self.divideandconquer(input, i+1,end)
                for r in right:
                    for l in left:
                        res.append(r + l)
                all_digit = False
            elif input[i] == '-':
                left = self.divideandconquer(input,start,i)
                right = self.divideandconquer(input, i+1,end)
                for l in left:
                    for r in right:
                        res.append(l - r)
                all_digit = False
            elif input[i] == '*':
                left = self.divideandconquer(input,start,i)
                right = self.divideandconquer(input, i+1,end)
                for l in left:
                    for r in right:
                        res.append(l * r)
                all_digit = False
            else:
                pass
        if all_digit:
            return [int(input[start: end]), ]
        return res

    # StefanPochmann的几种方法过于高端，充分的利用了python的特性，并没有懂，但是粘贴过来
    def diffWaysToCompute(self, input):
        tokens = re.split('(\D)', input)
        nums = map(int, tokens[::2])
        ops = map({'+': operator.add, '-': operator.sub, '*': operator.mul}.get, tokens[1::2])
        def build(lo, hi):
            if lo == hi:
                return [nums[lo]]
            return [ops[i](a, b)
                    for i in xrange(lo, hi)
                    for a in build(lo, i)
                    for b in build(i + 1, hi)]
        return build(0, len(nums) - 1)

if __name__ == "__main__":
    sl = Solution()
    print sl.diffWaysToCompute('2-1-1')

