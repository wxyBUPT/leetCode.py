#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import random

'''
398. Random Pick Index   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 10643
Total Submissions: 27199
Difficulty: Medium
Contributors: Admin
Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
'''

class Solution(object):

    # 77.71%
    def __init__(self, nums):
        """

        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums
        self.size = len(nums)

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        target_count = 0
        res = 0
        nums = self.nums
        for i in range(self.size):
            if nums[i] == target:
                target_count += 1
                ran = random.randint(1, target_count)
                if ran==target_count:
                    res = i
        return res


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)