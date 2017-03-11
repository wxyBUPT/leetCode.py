package main.java.bupt.wxy.greedy;

/**
 * Created by xiyuanbupt on 3/9/17.
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {

        int size=nums.length, f=1, d=1;
        for(int i=1;i<size;i++){
            if(nums[i]>nums[i-1])f=d+1;
            else if(nums[i]<nums[i-1])d=f+1;
        }
        return Math.min(size,Math.max(f,d));
    }
}
