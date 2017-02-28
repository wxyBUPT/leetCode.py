#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
 22. Generate Parentheses

    Total Accepted: 120622
    Total Submissions: 291002
    Difficulty: Medium
    Contributors: Admin

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
'''


class Solution(object):

    # 16.54%
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        self.backtracking(n, 0, [], res)
        return res

    def backtracking(self, n_left, n_right, curr, res):
        '''

        :param n_left: 还可以添加几个左括号
        :param n_right: 还可以添加几个右括号
        :param curr:
        :param res:
        :return:
        '''
        if not n_left and not n_right:
            res.append(''.join(curr))

        if n_left:
            curr.append('(')
            self.backtracking(n_left-1, n_right+1, curr, res)
            curr.pop()
        if n_right:
            curr.append(')')
            self.backtracking(n_left, n_right-1, curr, res)
            curr.pop()

    # 64.82%
    def generateParenthesis_str(self, n):
        res = []
        self.backtracking(n, 0, '', res)
        return res

    def backtracking_str(self, n_left, n_right, curr, res):

        if not n_left and not n_right:
            res.append(curr)

        if n_left:
            l_curr = curr + '('
            self.backtracking(n_left-1, n_right+1, l_curr, res)
        if n_right:
            r_curr = curr + ')'
            self.backtracking(n_left, n_right-1, r_curr, res)

    def stefanPochmann(self, n):
        def generate(p, left, right):
            if right >= left >= 0:
                if not right:
                    yield p
                for q in generate(p + '(', left-1, right): yield q
                for q in generate(p + ')', left, right-1): yield q
        return list(generate('', n, n))

