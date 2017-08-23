package bupt.wxy.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/3/17.
 18. 4Sum
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len-3;i++){
            if(i>0 && nums[i-1]==nums[i])continue;
            int target_3=target-nums[i];
            for(int j=i+1;j<len-2;j++){
                if(j>i+1 && nums[j-1]==nums[j])continue;
                int target_2 = target_3-nums[j];
                int k=j+1,l=len-1;
                while (k<l){
                    int sum = nums[k]+nums[l];
                    if(sum==target_2){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while (k<l&&nums[k]==nums[k+1])k++;
                        while (k<l&&nums[j]==nums[j-1])j--;
                        k++;l--;
                        continue;
                    }
                    if(sum<target_2)k++;
                    else l--;
                }
            }
        }
        return res;
    }
}
