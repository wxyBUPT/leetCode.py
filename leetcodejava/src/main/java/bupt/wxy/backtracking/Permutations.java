package main.java.bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/28/17.
 46. Permutations Add to List
 Difficulty: Medium
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations {

    // 21.36%
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited=new boolean[nums.length];
        List<List<Integer>> res=new LinkedList<>();
        backtracking(nums,visited,new LinkedList<>(), res);
        return res;
    }

    void backtracking(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> res){

        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                curr.add(nums[i]);
                backtracking(nums,visited,curr,res);
                visited[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }

}
