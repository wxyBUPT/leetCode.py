#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
215. Kth Largest Element in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 98497
Total Submissions: 264470
Difficulty: Medium
Contributors: Admin
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
'''

class Solution(object):

    # 使用快速排序解决
    # 还可以使用堆来解决
    # 20.49% 没有处于正常的区间，一定是自己的解决方法有问题
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        k = len(nums)-k
        lo = 0
        hi = len(nums)-1
        while lo<hi:
            j=self.partition(nums,lo,hi)
            if j<k:
                lo=j+1
            elif j>k:
                hi=j-1
            else:
                return nums[j]
        return nums[k]


    def partition(self, nums, lo, hi):

        i=lo+1
        j=hi
        while True:
            while i<hi and nums[i]<=nums[lo]:
                i+=1
            while j>lo and nums[j]>=nums[lo]:
                j-=1
            if i>=j:
                break
            nums[i],nums[j] = nums[j],nums[i]
        nums[lo],nums[j]=nums[j],nums[lo]
        return j

    def quickSort(self, nums):
        self.quick(nums, 0, len(nums)-1)


    def quick(self, nums, lo, hi):
        print u'quick'
        if lo>=hi:
            return
        i=self.partition(nums,lo,hi)
        self.quick(nums,lo,i-1)
        self.quick(nums,i+1,hi)


if __name__ == "__main__":
    sl = Solution()
    nums = [3,2,4,7,4,2,0,12,2,4,56,43,]
    print sl.partition(nums, 0, len(nums)-1)
    print nums
    sl.quickSort(nums)
    print nums
