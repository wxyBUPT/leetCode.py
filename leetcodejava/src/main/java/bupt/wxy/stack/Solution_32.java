package main.java.bupt.wxy.stack;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/15/17.
 32. Longest Valid Parentheses   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 83408
 Total Submissions: 361435
 Difficulty: Hard
 Contributors: Admin
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

/**
 * 这种对称问题一般都使用栈, 即使标签是dp
 * 而且脑筋不要太死, 栈中的元素可以是数组的下标
 */
public class Solution_32 {

    // 39.46%
    public int longestValidParentheses(String s) {

        Stack<Integer> stack=new Stack<>();

        int n=s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(')stack.push(i);
            else {
                if(!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') stack.pop();
                    else stack.push(i);
                }
                else stack.push(i);
            }
        }

        int res=0;

        int a=n,b=0;
        while (!stack.isEmpty()){
            b=stack.pop();
            res=Math.max(res,a-b-1);
            a=b;
        }
        res=Math.max(res,a);
        return res;
    }
}
