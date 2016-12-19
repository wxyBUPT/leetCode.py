#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import random
'''
384. Shuffle an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 15668
Total Submissions: 35089
Difficulty: Medium
Contributors: Admin
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
'''

class Fun(object):

    # 下面是leetcode名人的解法
    # he said just for fun
    # 因为函数是一等公民，使用了闭包
    def __init__(self, nums):
        """

        :type nums: List[int]
        :type size: int
        """
        self.reset = lambda :nums
        self.shuffle = lambda :random.sample(nums, len(nums))




# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()

# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()