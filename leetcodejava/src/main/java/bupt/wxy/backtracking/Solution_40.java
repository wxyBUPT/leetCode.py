package main.java.bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/8/17.
 40. Combination Sum II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 96350
 Total Submissions: 308226
 Difficulty: Medium
 Contributors: Admin
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class Solution_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new LinkedList<>();
        backtracking(candidates, new ArrayList<>(), res, 0, target, 0);
        return res;
    }

    void backtracking(int[] candidates, List<Integer> curr, List<List<Integer>> res, int index, int target, int sum){
        if(sum>target)return;
        if(sum==target)res.add(new ArrayList<>(curr));
        for(int i=index;i<candidates.length;i++){
            //
            if(i==index||candidates[i-1]!=candidates[i]){
                curr.add(candidates[i]);
                backtracking(candidates, curr,res,i+1,target,sum+candidates[i]);
                curr.remove(curr.size()-1);
            }
        }
    }
}
