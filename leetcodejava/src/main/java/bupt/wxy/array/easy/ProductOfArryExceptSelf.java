package bupt.wxy.array.easy;

/**
 * Created by xiyuanbupt on 2/28/17.
 238. Product of Array Except Self
 Difficulty: Medium
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

 Subscribe to see which companies asked this question.
 */
public class ProductOfArryExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] res=new int[nums.length];
        int left=1;
        for(int i=0;i<nums.length;i++){
            res[i]=left;
            left=left*nums[i];
        }

        int right=1;
        for(int i=nums.length-1;i>-1;i--){
            res[i]=res[i]*right;
            right=right*nums[i];
        }
        return res;
    }
}
