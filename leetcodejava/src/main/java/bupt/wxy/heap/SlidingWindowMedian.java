package main.java.bupt.wxy.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xiyuanbupt on 1/16/17.
 480. Sliding Window Median
 Total Accepted: 1475
 Total Submissions: 4520
 Difficulty: Hard
 Contributors: YutingLiu
 Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Median
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 Therefore, return the median sliding window as [1,-1,-1,3,5,6].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 */

/**
 * 本题踩了一个大坑是 float 转换相当有问题!!!!! 是不是智障!!!!!!
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {

        int len=nums.length;

        PriorityQueue<Integer> max=new PriorityQueue<>();
        PriorityQueue<Integer> min=new PriorityQueue<>(Collections.reverseOrder());

        double[] res=new double[len-k+1];

        for(int i=0;i<nums.length;i++) {

            max.offer(nums[i]);
            min.offer(max.poll());
            while (min.size() > max.size()) {
                max.add(min.poll());
            }

            if (i >= k-1) {
                // 此时可以求中间值了
                int index=i-k+1;
                if(max.size()>min.size())res[index]=1.0*max.peek();
                else {
                    res[index]=max.peek()/2.0+min.peek()/2.0;
                }
                if(nums[index]>=max.peek())max.remove(nums[index]);
                else min.remove(nums[index]);
            }
        }
        return res;
    }

    public static void main(String[] args){
        PriorityQueue<Integer> res=new PriorityQueue<>();
        res.add(1);
        System.out.println(res.remove(2));
    }
}
