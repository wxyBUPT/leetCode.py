package main.java.bupt.wxy.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by xiyuanbupt on 1/3/17.
 295. Find Median from Data Stream
 Total Accepted: 31735
 Total Submissions: 136591
 Difficulty: Hard
 Contributors: Admin
 Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.
 For example:

 add(1)
 add(2)
 findMedian() -> 1.5
 add(3)
 findMedian() -> 2
 */
public class FindMedianFromDataStream {

    PriorityQueue<Integer> max = new PriorityQueue<>();
    PriorityQueue<Integer> min = new PriorityQueue<>(1000, Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size()<min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(max.size()==min.size())return (max.peek()+min.peek())/2;
        return max.peek();
    }
}