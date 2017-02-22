package main.java.bupt.wxy.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiyuanbupt on 2/13/17.
 435. Non-overlapping Intervals
 Difficulty: Medium

 Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 Example 1:
 Input: [ [1,2], [2,3], [3,4], [1,3] ]

 Output: 1

 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 Example 2:
 Input: [ [1,2], [1,2], [1,2] ]

 Output: 2

 Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 Example 3:
 Input: [ [1,2], [2,3] ]

 Output: 0

 Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 Subscribe to see which companies asked this question.

 Show Tags
 Show Similar Problems

 */
public class NonOverlappingIntervals {
    class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s, int e){start=s;end=e;}
    }

    // 33.85%
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if(a.end==b.end)return b.start-a.start;
                return a.end-b.end;
            }
        });
        int end=Integer.MIN_VALUE;
        int res=0;
        for(Interval interval:intervals){
            if(interval.start>=end){
                end=interval.end;
            }else {
                res++;
            }
        }
        return res;
    }
}


