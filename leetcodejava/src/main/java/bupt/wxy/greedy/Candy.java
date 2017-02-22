package main.java.bupt.wxy.greedy;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 1/12/17.
 135. Candy
 Difficulty: Hard

 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?

 Subscribe to see which companies asked this question`
 */
public class Candy {

    // 68.94%
    public int candy(int[] ratings){
        int len=ratings.length;
        if(len<=1)return len;
        int[] counts=new int[len];
        // 至少分到一个糖果
        for(int i=0;i<len;i++){
            counts[i]=1;
        }
        for(int i=1;i<len;i++)
            if(ratings[i]>ratings[i-1])
                counts[i]=counts[i-1]+1;
        for(int i=len-1;i>0;i--)
            if(ratings[i-1]>ratings[i])
                counts[i-1]=Math.max(counts[i]+1, counts[i-1]);
        int res=0;
        for(int i:counts)res+=i;
        return res;

    }
    /**下面的解法糟糕透了
    public int candy(int[] ratings) {

        if(ratings.length==0)return 0;
        // 处理特殊情况
        boolean same=true;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]!=ratings[0]){
                same=false;
                break;
            }
        }
        if(same)return ratings.length;

        int[] res=new int[ratings.length+2];
        for(int i=0;i<ratings.length;i++){
            res[i+1]=ratings[i];
        }
        boolean changed=true;
        // 下面操作就是保证了相对顺序不变
        // 如果比两边都小取1,如果比两边都大,去最大的+1,如果在中间取最小的+1
        // 但是需要考虑中间一大片值相等的情况
        while (changed){
            changed=false;
            int i=0;
            while (i<res.length-2){
                while (i<res.length-2 && res[i]==res[i+1])i++;
                int j=i+1;
                while (j<res.length-1&&res[j]==res[j+1])j++;

                //开始改变中间的值
                int toval;
                if(res[i+1]<res[i]&&res[i+1]<res[j])
                    toval=1;
                else if(res[i+1]>res[i]&&res[i+1]>res[j])
                    toval=Math.max(res[i],res[j])+1;
                else
                    toval=Math.min(res[i],res[j])+1;
                if(toval!=res[i+1]){
                    changed=true;
                    for(int k=i+1;k<j;k++)res[k]=toval;
                }
                i=j-1;
            }
        }
        int ret=0;
        for(int i:res){
            ret+=i;
        }
        return ret;
    }
     **/
}
