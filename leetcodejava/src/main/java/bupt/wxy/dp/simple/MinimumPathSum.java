package main.java.bupt.wxy.dp.simple;

/**
 * Created by xiyuanbupt on 3/5/17.
 64. Minimum Path Sum
 Difficulty: Medium
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m,n;
        if((m=grid.length)==0||(n=grid[0].length)==0)return 0;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++)dp[i][0]=grid[i][0]+dp[i-1][0];
        for(int j=1;j<n;j++)dp[0][j]=grid[0][j]+dp[0][j-1];
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        return dp[m-1][n-1];
    }
}
