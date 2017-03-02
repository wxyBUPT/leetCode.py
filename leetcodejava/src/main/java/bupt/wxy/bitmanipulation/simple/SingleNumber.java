package main.java.bupt.wxy.bitmanipulation.simple;

/**
 * Created by xiyuanbupt on 3/1/17.
 136. Single Number Add to List
 Description  Submission  Solutions
 Total Accepted: 195970
 Total Submissions: 368143
 Difficulty: Easy
 Contributors: Admin
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {

    // 38.94%
    public int singleNumber(int[] nums) {
        int res=0;
        for(int num:nums){
            res^=num;
        }
        return res;
    }
}
