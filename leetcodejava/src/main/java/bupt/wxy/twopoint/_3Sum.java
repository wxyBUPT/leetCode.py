package bupt.wxy.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/3/17.
 15. 3Sum   Add to List QuestionEditorial Solution  My Submissions
 Difficulty: Medium

 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
// 一般的题目都是这样,首先想到时间复杂度不是很好的操作
    // 另外一般的题目使用set去重,已经不是一个很好的方法了
public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0;i<len-2;i++){
            if(i>0 && nums[i-1]==nums[i])continue;
            int remain = -nums[i];
            int j=i+1,k=len-1;
            while (j<k){
                int sum = nums[j]+nums[k];
                if(sum==remain){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j<k && nums[j]==nums[j+1])j++;
                    while (j<k && nums[k]==nums[k-1])k--;
                    j++;k--;
                    continue;
                }
                if(sum>remain)k--;
                else j++;
            }
        }
        return res;
    }
}
