package main.java.bupt.wxy.backtracking;

import java.util.*;

/**
 * Created by xiyuanbupt on 2/2/17.
 93. Restore IP Addresses   Add to List QuestionEditorial Solution  My Submissions
 Difficulty: Medium

 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddress {

    // 15.63%
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new LinkedList<>();
        backtracking(s,0,new ArrayList<>(4),res);
        return res;
    }

    void backtracking(String s, int index, List<String> curr, List<String> res){

        boolean cosumed=index==s.length(), full=curr.size()==4;
        if(cosumed||full){
            if(cosumed&&full){
                res.add(String.join(".",curr));
            }
            return;
        }

        for(int i=1;i<4;i++){
            if(index+i>s.length())return;
            String seg = s.substring(index,index+i);
            if(i>1&&seg.startsWith("0"))return;
            int int_seg=Integer.valueOf(seg);
            if(int_seg>=0&&int_seg<256){
                curr.add(seg);
                backtracking(s,index+i,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
}
