package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 1/16/17.
 115. Distinct Subsequences

 Difficulty: Hard

 Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.
 */

/**
 * 本题目和两点问题  MinmumWindowSubstring 有点类似, 但是本题目是有序的
 * 第一想法是使用
 * 因为条件更加苛刻, 所有dp比较容易解决
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {

        int[][] dp=new int[t.length()+1][s.length()+1];
        for(int i=0;i<s.length();i++)dp[0][i]=1;

        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(t.charAt(i)==s.charAt(j))dp[i+1][j+1]=dp[i+1][j]+dp[i][j];
                else dp[i+1][j+1]=dp[i+1][j];
            }
        }
        return dp[t.length()][s.length()];
    }
}
