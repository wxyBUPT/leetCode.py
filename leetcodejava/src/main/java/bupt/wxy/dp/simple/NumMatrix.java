package main.java.bupt.wxy.dp.simple;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 1/10/17.
 304. Range Sum Query 2D - Immutable
 Difficulty: Medium

 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 sumRegion(1, 1, 2, 2) -> 11
 sumRegion(1, 2, 2, 4) -> 12

 */
public class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int m,n;
        if((m=matrix.length)==0||(n=matrix[0].length)==0)return;
        dp=new int[m+1][n+1];
        dp[1][1]=matrix[0][0];

        for(int i=1;i<m;i++)dp[i+1][1]=dp[i][1]+matrix[i][0];
        for(int i=1;i<n;i++)dp[1][i+1]=dp[1][i]+matrix[0][i];
        for(int i=2;i<=m;i++)
            for(int j=2;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+matrix[i-1][j-1]-dp[i-1][j-1];
            }
        for(int i=0;i<=m;i++)
            System.out.println(Arrays.toString(dp[i]));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }

}
