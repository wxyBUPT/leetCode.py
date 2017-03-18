package main.java.bupt.wxy.array.easy;

import java.util.List;

/**
 * Created by xiyuanbupt on 3/12/17.
 539. Minimum Time Difference My SubmissionsBack To Contest
 Difficulty: Medium
 Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

 Example 1:
 Input: ["23:59","00:00"]
 Output: 1
 Note:
 The number of time points in the given list is at least 2 and won't exceed 20000.
 The input time is legal and ranges from 00:00 to 23:59.
 */
public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size()<2)return 0;
        int[] map=new int[24*60];
        for(String times:timePoints){
            map[str2int(times)]++;
        }
        for(int i:map)if(i>1)return 0;

        int startIndex=0;
        while (map[startIndex]==0)startIndex++;
        int preIndex=startIndex;
        int res=Integer.MAX_VALUE;
        int i=startIndex+1;
        for(;i<map.length;i++){
            if(map[i]!=0){
                res=Math.min(res,i-preIndex);
                preIndex=i;
            }
        }
        return Math.min(res, startIndex-preIndex+24*60);

    }

    int str2int(String times){
        int hours=Integer.parseInt(times.substring(0,2));
        int minutes=Integer.parseInt(times.substring(3,5));
        return hours*60+minutes;
    }

}
