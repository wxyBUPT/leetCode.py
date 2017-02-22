package main.java.bupt.wxy.array.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/10/17.
 228. Summary Ranges

 Difficulty: Medium
 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res=new LinkedList<>();
        if(nums.length==0)return res;
        int start=nums[0];
        for(int i=1;i<nums.length+1;i++){
            if(i==nums.length||nums[i]!=nums[i-1]+1){
                if(nums[i-1]==start){
                    res.add(Integer.toString(start));
                }
                else {
                    StringBuilder sb=new StringBuilder();
                    sb.append(start).append("->").append(nums[i-1]);
                    res.add(sb.toString());
                }
                if(i<nums.length) {
                    start = nums[i];
                }
            }
        }
        return res;

    }

    // 因为上述算法在平均时间下游,看discus觉得下面的算法比我的算法要好
    // 哈哈哈,和上述算法同样时间
    public List<String> summaryRanges2(int[] nums){
        List<String> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int start=nums[i];
            while (i+1<nums.length&&(nums[i+1]-nums[i])==1)i++;
            if(start==nums[i])res.add(Integer.toString(start));
            else {
                StringBuilder sb=new StringBuilder();
                sb.append(start).append("->").append(nums[i]);
                res.add(sb.toString());
            }
        }
        return res;
    }
}
