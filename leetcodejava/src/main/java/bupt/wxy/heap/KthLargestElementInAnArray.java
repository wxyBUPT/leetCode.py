package main.java.bupt.wxy.heap;

import java.util.PriorityQueue;

/**
 * Created by xiyuanbupt on 3/12/17.
 215. Kth Largest Element in an Array
 Difficulty: Medium
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(k);
        for(int num:nums){
            if(priorityQueue.size()<k||priorityQueue.peek()<num)priorityQueue.offer(num);
            if(priorityQueue.size()>k)priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
