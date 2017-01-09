package main.java.bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/9/17.
 47. Permutations II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 100540
 Total Submissions: 324763
 Difficulty: Medium
 Contributors: Admin
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class Solution_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backtracking(nums,used,new ArrayList<>(nums.length), res);
        return res;
    }

    // 如果前面的没用到, 后面的更不需要被用到啊, 使用for都成为套路了
    void backtracking(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            if(i>0&&nums[i-1]==nums[i]&&!used[i-1])continue;
            used[i]=true;
            curr.add(nums[i]);
            backtracking(nums,used,curr,res);
            used[i]=false;
            curr.remove(curr.size()-1);
        }
    }


}
