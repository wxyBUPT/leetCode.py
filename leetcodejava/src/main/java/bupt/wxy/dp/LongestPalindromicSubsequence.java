package main.java.bupt.wxy.dp;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by xiyuanbupt on 2/13/17.
 516. Longest Palindromic Subsequence
 Description  Submission  Solutions  Add to List
 Total Accepted: 995
 Total Submissions: 2520
 Difficulty: Medium
 Contributors: Stomach_ache
 Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".
 Subscribe to see which companies asked this question.
 */
public class LongestPalindromicSubsequence {

    // 68.99%
    public int longestPalindromeSubseq(String s){
        char[] str=s.toCharArray();

        int[][] dp=new int[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<s.length();j++){
                if(str[i]==str[j])dp[i][j]=dp[i+1][j-1]+2;
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }

    // 3.80%
    public int longestPalindromeSubseqBad(String s) {
        char[] str=s.toCharArray();

        int len=s.length();
        int[][] dp=new int[len][len];
        for(int i=0;i<len;i++)dp[i][i]=1;
        for(int i=0;i<len-1;i++) {

            if (str[i] == str[i + 1]) dp[i][i + 1] = 2;
            else dp[i][i+1]=1;
        }
        for(int dist=2;dist<=len;dist++){
            // 求每个 i 到 i+dist 的dp值
            // dp[i][i+dist]
            for(int i=0;i<len-dist;i++){
                int j=i+dist;
                int i_j_max= Math.max(dp[i][j-1],dp[i+1][j]);
                /**使用下面代码超时
                for(int k=i+2;k<=j;k++)if(str[i]==str[k])i_j_max=Math.max(i_j_max,2+dp[i+1][k-1]);
                for(int k=j-2;k>=i;k--)if(str[j]==str[k])i_j_max=Math.max(i_j_max,2+dp[k+1][j-1]);
                 **/
                if(str[i]==str[j])i_j_max=Math.max(i_j_max,dp[i+1][j-1]+2);
                dp[i][j]=i_j_max;
            }
        }
        return dp[0][len-1];
    }
}
