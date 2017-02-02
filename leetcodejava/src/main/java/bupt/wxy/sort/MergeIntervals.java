package main.java.bupt.wxy.sort;

import java.util.*;

/**
 * Created by xiyuanbupt on 2/2/17.
 56. Merge Intervals   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 102965
 Total Submissions: 359882
 Difficulty: Medium
 Contributors: Admin
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        int start=Integer.MIN_VALUE;
        int end=Integer.MIN_VALUE;

        for(Interval interval:intervals){
            if(interval.start>end){
                res.add(new Interval(start,end));
                start=interval.start;
                end=interval.end;
            }
            else {
                end=Math.max(interval.end,end);
            }
        }
        res.add(new Interval(start,end));
        if(res.size()>0) {
            Interval first = res.get(0);
            if (first.start == first.end) res.remove(0);
        }
        return res;
    }
}

class Interval{
    int start;
    int end;
    Interval(){
        start=0;
        end=0;
    }
    Interval(int s, int e){
        start=s;
        end=e;
    }
}