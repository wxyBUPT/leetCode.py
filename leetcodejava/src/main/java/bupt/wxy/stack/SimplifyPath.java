package main.java.bupt.wxy.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/11/17.
 71. Simplify Path
 Total Accepted: 72714
 Total Submissions: 302988
 Difficulty: Medium
 Contributors: Admin
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 click to show corner cases.

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".
 Subscribe to see which companies asked this question

 Stack String
 */

public class SimplifyPath {

    // 73.76%
    public String simplifyPath(String path) {
        String[] list=path.split("/");
        Stack<String> paths=new Stack<>();
        if(list.length==0)return "/";
        for(String s:list){

            if(s.equals("..")) {
                if (!paths.isEmpty()) paths.pop();
                continue;
            }
            else if(s.equals("")||s.equals(".")){}
            else paths.push(s);
        }
        StringBuilder sb=new StringBuilder();
        while (!paths.isEmpty()){
            sb.append("/").append(paths.remove(0));
        }
        if(sb.length()==0)return "/";

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString("/../b/./".split("/")));
    }
}
