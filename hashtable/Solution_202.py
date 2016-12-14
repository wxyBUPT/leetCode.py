#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''

202. Happy Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 100440
Total Submissions: 257698
Difficulty: Easy
Contributors: Admin
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
'''

class Solution(object):

    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 1:
            return True
        visited = set()
        while n not in visited:
            visited.add(n)
            n = self.getSum(n)
            if n == 1:
                return True
        return False


    def getSum(self, n):
        sum = 0
        while n:
            tmp = n % 10
            sum += tmp * tmp
            n = n / 10
        return sum

    # 对于这种有环路的问题，使用快慢指针
    def isHappy2(self, n):

        fast = self.getSum(self.getSum(n))
        slow = self.getSum(n)
        while fast != slow:
            fast = self.getSum(self.getSum(fast))
            slow = self.getSum(slow)
        if fast == 1:
            return True
        else:
            return False

if __name__ == "__main__":
    sl = Solution()
    print sl.isHappy(19)