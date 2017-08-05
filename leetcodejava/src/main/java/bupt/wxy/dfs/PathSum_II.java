package bupt.wxy.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/5/17.
 113. Path Sum II
 Difficulty: Medium

 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(root,sum,0,new ArrayList<>(), res);
        return res;
    }

    void dfs(TreeNode root, int sum, int curr_sum, List<Integer> curr, List<List<Integer>> res){
        if(root==null)return;
        if(root.left==null&&root.right==null&&root.val+curr_sum==sum){
            List<Integer> next=new ArrayList<>(curr);
            next.add(root.val);
            res.add(next);
            return;
        }
        curr.add(root.val);
        dfs(root.left, sum, curr_sum+root.val, curr, res);
        dfs(root.right, sum, curr_sum+root.val, curr, res);
        curr.remove(curr.size()-1);
    }
}
