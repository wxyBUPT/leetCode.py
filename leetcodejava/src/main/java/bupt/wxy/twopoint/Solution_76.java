package main.java.bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 1/16/17.
 76. Minimum Window Substring   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 86145
 Total Submissions: 361236
 Difficulty: Hard
 Contributors: Admin
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

/**
 * 当两点满足某条件即可
 */
public class Solution_76 {

    public String minWindow(String s, String t) {
        int[] map=new int[128];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        char[] chars=s.toCharArray();

        int count=t.length(), begin=0,end=0,d=Integer.MAX_VALUE, head=0;
        while (end<s.length()){
            // 之前是大于0的
            if(map[chars[end++]]-->0)count--;
            // 都是满足条件的点
            while (count==0){
                if(end-begin<d)d=end-(head=begin);
                if(map[chars[begin++]]++==0)count++;
            }
        }
        return d==Integer.MAX_VALUE?"":s.substring(head,head+d);
    }
}
