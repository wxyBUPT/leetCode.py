package bupt.wxy.array.easy;

/**
 * Created by xiyuanbupt on 2/14/17.
 485. Max Consecutive Ones
 Difficulty: Easy

 Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    // 47.94%
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0)return 0;
        int curr=nums[0]==0?0:1;
        int max=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==1)curr++;
            else {
                max=Math.max(curr,max);
                curr=0;
            }
        }
        return Math.max(curr,max);
    }
}
