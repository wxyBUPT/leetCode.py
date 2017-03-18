package main.java.bupt.wxy.backtracking.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/27/17.
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {

    // 59.47%
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        backtracking(n,0,curr,res);
        return res;
    }

    void backtracking(int left, int right, StringBuilder curr, List<String> res){

        if(left==0&&right==0)res.add(curr.toString());

        if(left>0){
            curr.append("(");
            backtracking(left-1,right+1,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }
        if(right>0){
            curr.append(")");
            backtracking(left,right-1,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
