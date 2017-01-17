package main.java.bupt.wxy.dp.simple;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 1/11/17.
 221. Maximal Square
 Total Accepted: 49407
 Total Submissions: 182521
 Difficulty: Medium
 Contributors: Admin
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 */
public class MaximalSquare {

    // 96.31%
    public int maximalSquare(char[][] matrix) {
        int m,n;
        if((m=matrix.length)==0||(n=matrix[0].length)==0)return 0;
        int[][] dp=new int[m][n];
        int max=0;
        for(int i=0;i<m;i++)if(matrix[i][0]=='1')dp[i][0]=1;
        for(int i=0;i<n;i++)if(matrix[0][i]=='1')dp[0][i]=1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    int res=1;
                    for(int dist=1;dist<=dp[i-1][j-1];dist++){
                        if(matrix[i-dist][j]=='1'&&matrix[i][j-dist]=='1')res++;
                        else break;
                    }
                    dp[i][j]=res;
                }
            }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                max=Math.max(max,dp[i][j]);
        return max*max;

    }
}
