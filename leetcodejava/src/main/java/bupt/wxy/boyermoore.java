package main.java.bupt.wxy;

/**
 * Created by xiyuanbupt on 1/10/17.
 229. Majority Element II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 45460
 Total Submissions: 163971
 Difficulty: Medium
 Contributors: Admin
 Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 摩尔投票法
 */
public class boyermoore {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=0,count1=0;
        int candidate2=1,coutn2=0;
        for(int n:nums){
            if(n==candidate1)count1++;
            else if(n==candidate2)coutn2++;
            else if(count1==0){candidate1=n;count1++;}
            else if(coutn2==0){candidate2=n;coutn2++;}
            else {
                count1--;
                coutn2--;
            }
        }
        List<Integer> res=new ArrayList<>();
        count1=0;
        coutn2=0;
        for(int n:nums){
            if(n==candidate1)count1++;
            if(n==candidate2)coutn2++;
        }
        if(count1>nums.length/3)res.add(candidate1);
        if(coutn2>nums.length/3)res.add(candidate2);
        return res;
    }

    public static void main(String[] args){
        Integer a=new Integer(10);
        int b=10;
        System.out.println(a==b);
    }
}
