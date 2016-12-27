#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
import heapq

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
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pass

'''使用java 的算法如下
public class Solution_215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1 );
        int min = Integer.MIN_VALUE;
        for(int num: nums){
            if(num>min || queue.size()<k){
                queue.offer(num);
                if(queue.size()>k)queue.poll();
                min = queue.peek();
            }
        }
        return queue.peek();
    }
}
'''