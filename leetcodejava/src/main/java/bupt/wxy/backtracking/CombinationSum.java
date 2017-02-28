package main.java.bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/28/17.
 39. Combination Sum Add to List
 Description  Submission  Solutions
 Total Accepted: 141281
 Total Submissions: 387256
 Difficulty: Medium
 Contributors: Admin
 Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum {

    // 21.54%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new LinkedList<>();
        backtracking(candidates,new LinkedList<>(), res, 0, target);
        return res;
    }

    void backtracking(int[] candidates, List<Integer> curr, List<List<Integer>> res, int sum, int target){
        if(sum>target)return;
        if(sum==target){
            res.add(new ArrayList<>(curr));
            return;
        }

        // 为了不使用set去重, 比最后一个元素小的不要加入
        for(int i=0, len=candidates.length;i<len;i++){
            int size=curr.size();
            if(size!=0&&candidates[i]<curr.get(size-1))continue;
            curr.add(candidates[i]);
            backtracking(candidates,curr,res,sum+candidates[i],target);
            curr.remove(size);
        }
    }
}
