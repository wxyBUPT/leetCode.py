package main.java.bupt.wxy.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/8/17.
 120. Triangle
 Difficulty: Medium

 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n;
        if((n=triangle.size())==0)return 0;
        int[][] array=new int[n][n];
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                array[i][j]=triangle.get(i).get(j);
            }
        }

        dp[0][0]=array[0][0];
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+array[i][0];
            dp[i][i]=dp[i-1][i-1]+array[i][i];
            for(int j=1;j<i;j++)
                dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+array[i][j];
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res=Math.min(res,dp[n-1][i]);
        }
        return res;
    }
}
