package main.java.bupt.wxy.string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/15/17.
 14. Longest Common Prefix
 Total Accepted: 144384
 Total Submissions: 472211
 Difficulty: Easy
 Contributors: Admin
 Write a function to find the longest common prefix string amongst an array of strings.

 Subscribe to see which companies asked this question

 Hide Tags
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
