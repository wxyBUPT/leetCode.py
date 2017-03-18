package main.java.bupt.wxy.greedy;

/**
 * Created by xiyuanbupt on 2/2/17.
 45. Jump Game II
 Difficulty: Hard
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {

    /**
     * 21.05%
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length<2)return 0;
        int res=0;
        int curr=0;

        int max_reach=nums[0];
        while (max_reach+1<nums.length){
            res++;
            int tmp=curr;
            for(int i=1;i<=nums[tmp];i++){
                if(tmp+i+nums[tmp+i]>max_reach){
                    curr=tmp+i;
                    max_reach=tmp+i+nums[tmp+i];
                }
            }
        }
        return res+1;
    }
}
