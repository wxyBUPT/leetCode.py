#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
189. Rotate Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 103012
Total Submissions: 441759
Difficulty: Easy
Contributors: Admin
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
'''

class Solution(object):

    # 75.92%
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        tmp = nums[len(nums) - k :len(nums)] + nums[0:len(nums) - k]
        for i in range(len(nums)):
            nums[i] = tmp[i]

    # 使用两次翻转
    def rotate2(self, nums, k):
        '''

        :param nums:
        :param k:
        :return:
        '''
        k = k % len(nums) 
        self.reverse(nums, 0 , len(nums) - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, len(nums) - 1)

    def reverse(self, nums, start, end):
        while start < end:
            tmp = nums[start]
            nums[start] = nums[end]
            nums[end] = tmp
            start += 1
            end -= 1





