package main.java.bupt.wxy.array.easy;

import java.util.*;

/**
 * Created by xiyuanbupt on 2/13/17.
 506. Relative Ranks
 Difficulty: Easy

 Given scores of N athletes, find their relative ranks and the people with the top
 three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

 Example 1:
 Input: [5, 4, 3, 2, 1]
 Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 For the left two athletes, you just need to output their relative ranks according to their scores.
 Note:
 N is a positive integer and won't exceed 10,000.
 All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums){

        // 存储对应的得分和下标
        int[][] pairs = new int[nums.length][2];
        for(int i=0; i<nums.length;i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return - o1[0] + o2[0];
            }
        });
        String[] res = new String[nums.length];
        for(int i=0, len=nums.length;i<len;i++){
            if(i>2)res[pairs[i][1]]=String.valueOf(i+1);
            else {
                if(i==0)res[pairs[i][1]]="Gold Medal";
                else if(i==1)res[pairs[i][1]] = "Silver Medal";
                else res[pairs[i][1]] ="Bronze Medal";
            }
        }
        return res;
    }

    // 使用treemap比较容易想到, 直接利用红黑树排序
    public String[] findRelativeRanksTreeMap(int[] nums) {

        // 45.48%
        NavigableMap<Integer,Integer> treeMap=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            treeMap.put(nums[i],i);
        }

        String[] res=new String[nums.length];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:treeMap.entrySet()){
            i++;
            if(i==1){
                res[entry.getValue()]="Gold Medal";
            }
            else if(i==2){
                res[entry.getValue()]="Silver Medal";
            }
            else if(i==3){
                res[entry.getValue()]="Bronze Medal";
            }else {
                res[entry.getValue()]=String.valueOf(i);
            }
        }
        return res;
    }
}
