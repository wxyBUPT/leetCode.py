package main.java.bupt.wxy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 1/13/17.
 219. Contains Duplicate II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 91930
 Total Submissions: 291661
 Difficulty: Easy
 Contributors: Admin
 Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that
 nums[i] = nums[j] and the absolute difference between i and j is at most k.


 */
public class ContainsDuplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen=new HashSet<>();
        for(int i=0;i<nums.length&&i<=k;i++){
            if(seen.contains(nums[i]))return true;
            seen.add(nums[i]);
        }
        for(int i=0,j=k+1;j<nums.length;){
            seen.remove(nums[i++]);
            if(seen.contains(nums[j]))return true;
            seen.add(nums[j++]);
        }
        return false;
    }
}
