package main.java.bupt.wxy.backtracking.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/28/17.
 78. Subsets
 Difficulty: Medium
 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subsets {

    // 32.78%
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), res);
        return res;
    }

    void backtracking(int[] nums, int index, List<Integer> curr, List<List<Integer>> res ){
        res.add(curr);
        for(int i=index;i<nums.length;i++){
            List<Integer> next=new ArrayList<>(curr);
            next.add(nums[i]);
            backtracking(nums,i+1,next,res);
        }
    }
}
