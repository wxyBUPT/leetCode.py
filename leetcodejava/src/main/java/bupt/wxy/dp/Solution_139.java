package main.java.bupt.wxy.dp;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/9/17.
 139. Word Break   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 122285
 Total Submissions: 433872
 Difficulty: Medium
 Contributors: Admin
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution_139 {

    public boolean wordBreakdp(String s,List<String > wordDict){
        boolean[] dp=new boolean[s.length()+1];
        Set<String> set=new HashSet<>(wordDict);
        dp[0]=true;
        int len=s.length();
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    Set<String> seen=new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict){
        if(s.length()==0)return true;
        if(seen.contains(s))return false;
        seen.add(s);
        for(String word:wordDict){
            if(s.startsWith(word)&&wordBreak(s.substring(word.length()),wordDict))return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("abcd".substring(1,2));
    }


    /**
     * 下面的算法不是最好的!!!!
     */

    List<char[]> words;
    char[] str;
    int s_len;
    boolean[] visited;

    // 看discuss发现有更好的解决办法
    // 没有按照题目使用dp, 结果就是超时
    // dp一半的题目都是先想有没有正确的解决办法,然后向dp靠近
    public boolean wordBreakBad(String s, List<String> wordDict) {
        words=new ArrayList<>(wordDict.size());
        str=s.toCharArray();
        visited=new boolean[str.length];
        Set<Character> seen=new HashSet<>();
        for(Character c:str){
            seen.add(c);
        }
        for(String word:wordDict){
            char[] tmp=word.toCharArray();
            words.add(tmp);
            for(Character c:tmp){
                seen.remove(c);
            }
        }
        if(seen.size()>0)return false;
        Collections.sort(words, new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                return -o1.length+o2.length;
            }
        });
        s_len=str.length;
        return wordBreak(0);
    }

    boolean wordBreak(int i){
        if(i==s_len)return true;
        if(visited[i])return false;
        for(char[] word:words){
            boolean startWith=true;
            if(i+word.length>s_len)continue;
            for(int j=0;j<word.length;j++){
                if(word[j]!=str[i+j]){
                    startWith=false;
                    break;
                }
            }
            if(startWith&&wordBreak(i+word.length))return true;
        }
        visited[i]=true;
        return false;
    }
}
