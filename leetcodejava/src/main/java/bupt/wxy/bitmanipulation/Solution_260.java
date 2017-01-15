package main.java.bupt.wxy.bitmanipulation;

/**
 * Created by xiyuanbupt on 1/15/17.
 260. Single Number III   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 56818
 Total Submissions: 115391
 Difficulty: Medium
 Contributors: Admin
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 Subscribe to see which companies asked this question

 Show Tags
 Show Similar Problems

 */

/**
 * 利用位操作, 但是我也不是很理解
 */
public class Solution_260 {

    public int[] singleNumber(int[] nums) {
        int diff=0;
        for(int num:nums){
            diff^=num;
        }
        // 下面这条是求a 和b 最后一个不同的bit
        // diff 最后一个bit 已经代表 a b 在这里有不同了, 下面就是获得bit的位置
        int lastdiff=(diff&(diff-1))^diff;
        int[] res=new int[2];
        for(int num:nums){
            if((num&lastdiff)>0)res[0]=res[0]^num;
            else res[1]=res[1]^num;
        }
        return res;
    }
}
