package main.java.bupt.wxy.divideandconquer;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by xiyuanbupt on 3/2/17.
 241. Different Ways to Add Parentheses
 Difficulty: Medium
 Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]


 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        return divideAndConquer(input);
    }

    private List<Integer> divideAndConquer(String string){
        List<Integer> res=new LinkedList<>();
        boolean alldigits=true;
        int len=string.length();
        for(int i=0;i<len;i++){
            char c=string.charAt(i);
            if(c=='+'){
                alldigits=false;
                List<Integer> lefts=divideAndConquer(string.substring(0,i));
                List<Integer> rights=divideAndConquer(string.substring(i+1));
                for(int left:lefts)
                    for(int right:rights){
                        res.add(left+right);
                    }
            }
            else if(c=='-'){
                alldigits=false;
                List<Integer> lefts=divideAndConquer(string.substring(0,i));
                List<Integer> rights=divideAndConquer(string.substring(i+1));
                for(int left:lefts)
                    for(int right:rights){
                        res.add(left-right);
                    }
            }
            else if(c=='*'){
                alldigits=false;
                List<Integer> lefts=divideAndConquer(string.substring(0,i));
                List<Integer> rights=divideAndConquer(string.substring(i+1));
                for(int left:lefts)
                    for(int right:rights){
                        res.add(left*right);
                    }
            }
            else {

            }
        }
        if(alldigits)res.add(Integer.valueOf(string));
        return res;
    }

}
