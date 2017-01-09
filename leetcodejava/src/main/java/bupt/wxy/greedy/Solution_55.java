package main.java.bupt.wxy.greedy;

/**
 * Created by xiyuanbupt on 1/8/17.
 55. Jump Game   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 105180
 Total Submissions: 360618
 Difficulty: Medium
 Contributors: Admin
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */

/**
 * 使用贪心算法, 没一回都跳到下一次能跳到最远的地方
 */
public class Solution_55 {

    public boolean canJump(int[] nums) {
        int win_point=nums.length-1;
        int curr=0;
        while (curr<win_point){
            if(curr+nums[curr]>=win_point)return true;
            if(nums[curr]==0)return false;
            int max_reach=curr+1;
            int step=nums[curr];
            int next=curr+1;
            for(int i=1;i<=step;i++){
                if(curr+i+nums[curr+i]>max_reach){
                    max_reach=curr+i+nums[curr+i];
                    next=curr+i;
                }
            }
            curr=next;
        }
        return true;
    }
}
