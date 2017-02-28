package main.java.bupt.wxy.array;

/**
 * Created by xiyuanbupt on 2/28/17.
 334. Increasing Triplet Subsequence Add to List
 Description  Submission  Solutions
 Total Accepted: 34192
 Total Submissions: 89571
 Difficulty: Medium
 Contributors: Admin
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:
 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Examples:
 Given [1, 2, 3, 4, 5],
 return true.

 Given [5, 4, 3, 2, 1],
 return false.
 */
public class IncreasingTripletSubsequence {

    // 38.64%
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)return false;
        int first_index=0;
        int second_index=0;
        for(int i=1;i<nums.length;i++){
            if(second_index==0){
                if(nums[i]<nums[first_index])first_index=i;
                else if(nums[i]>nums[first_index]) {
                    second_index=i;
                }else {

                }
            }else {
                if(nums[i]<nums[first_index])first_index=i;
                else if(nums[i]>nums[first_index]){
                    if(nums[i]<nums[second_index])second_index=i;
                    else if(nums[i]>nums[second_index])return true;
                    else {

                    }
                }
                else {

                }
            }
        }
        return false;
    }
}
