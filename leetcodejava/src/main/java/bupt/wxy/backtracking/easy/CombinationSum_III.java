package bupt.wxy.backtracking.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/28/17.
 216. Combination Sum III
 Difficulty: Medium
 Find all possible combinations of k numbers that add up to a number n,
 given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class CombinationSum_III {

    // 13.23%
    private int k=0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k=k;
        List<List<Integer>> res=new LinkedList<>();
        backtracking(0,0,n,new LinkedList<>(), res);
        return res;
    }

    void backtracking(int index, int sum, int n, List<Integer> curr,List<List<Integer>> res){
        if(curr.size()==k){
            if(sum==n)res.add(new ArrayList<>(curr));
            return;
        }
        if(index==9)return;
        for(int i=index+1;i<10;i++){
            curr.add(i);
            backtracking(i,sum+i,n,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}
