package main.java.bupt.wxy.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/2/17.
 57. Insert Interval
 Difficulty: Hard

 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


 */
public class InsertInterval {

    // 我觉得最难的就是这种处理区间的问题了..... 本算法空间复杂度为O(1)(下面有空间复杂度为O(n)的算法), 所以执行时间不好
    // 12.15%
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals=new ArrayList<>(intervals);

        int inser_index=0;
        // 二分查找左插入点
        int lo=0,hi=intervals.size();
        int target=newInterval.start;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            int val =intervals.get(mid).start;
            if(val>=target)hi=mid;
            else lo=mid+1;
        }
        inser_index=lo;
        while (inser_index<intervals.size()&&intervals.get(inser_index).end<=newInterval.end)intervals.remove(inser_index);
        if(inser_index<intervals.size()&&intervals.get(inser_index).start<=newInterval.end){
            newInterval.end=intervals.get(inser_index).end;
            intervals.remove(inser_index);
        }
        // 首先处理不需要插入的情况
        if(inser_index>0&&intervals.get(inser_index-1).end>=newInterval.start){
            Interval pre=intervals.get(inser_index-1);
            pre.end=Math.max(pre.end,newInterval.end);
        }else {
            intervals.add(inser_index, newInterval);
        }
        return intervals;
    }

    public List<Interval> insert2(List<Interval> intervals, Interval newInterval){
        List<Interval> res=new ArrayList<>(intervals.size());
        boolean inserted=false;
        for(Interval interval:intervals){
            if(interval.end<newInterval.start || interval.start>newInterval.end){
                if(!inserted){
                    inserted=true;
                    res.add(newInterval);
                }
                res.add(interval);
            }
            else {
                if(interval.start<newInterval.start)newInterval.start=interval.start;
                if(interval.end>newInterval.end)newInterval.end=interval.end;
            }
        }
        return res;
    }
}
