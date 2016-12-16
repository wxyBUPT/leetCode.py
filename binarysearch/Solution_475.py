#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import bisect
'''
475. Heaters   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 1971
Total Submissions: 6575
Difficulty: Easy
Contributors: neelamgehlot
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
'''

class Solution(object):

    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        heaters = sorted(heaters) + [float('inf')]
        i = r = 0
        # 对每一个house都执行最大值的遍历
        for x in sorted(houses):
            # 找到距离house最近的点
            while x >= sum(heaters[i:i+2])/ 2.:
                i += 1
            # 计算距离
            r = max(r, abs(heaters[i] - x))
        return r

    # 太高深了，没有懂
    # 其实看别人基于二分查找的代码想法也比较类似，对每一个房子查找距离最近的两点
    # 然后选择两点中距离最下的那个
    def findRadiusBinary(self, houses, heaters):
        heaters.sort()
        return max(min(abs(house - heater) for i in [bisect.bisect(heaters, house)]
                       for heater in heaters[i-(i>0):i+1])
                   for house in houses)


