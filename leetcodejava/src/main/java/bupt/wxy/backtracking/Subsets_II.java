package main.java.bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/4/17.
 90. Subsets II
 Difficulty: Medium

 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        backtracking(nums, new ArrayList<>(nums.length), 0, res);
        return res;
    }

    void backtracking(int[] nums, List<Integer> curr, int index, List<List<Integer>> res){
        res.add(curr);
        for(int i=index;i<nums.length;i++){
            if(i>index &&nums[i]==nums[i-1])continue;
            List<Integer> next=new ArrayList<>(curr);
            next.add(nums[i]);
            backtracking(nums, next, i+1, res);
        }
    }

    // 非递归的比较难想
    public List<List<Integer>> subsetsWithDup2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        int startIndex=0;
        int size=0;
        for(int i=0;i<nums.length;i++){
            startIndex=i>=1&&nums[i]==nums[i-1]?size:0;
            size=res.size();
            for(int j=startIndex;j<size;j++){
                List<Integer> next=new ArrayList<>(res.get(j));
                next.add(nums[i]);
                res.add(next);
            }
        }
        return res;
    }
}
