package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 1/8/17.
 63. Unique Paths II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 88594
 Total Submissions: 286671
 Difficulty: Medium
 Contributors: Admin
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 */
public class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m,n;
        if((m=obstacleGrid.length)==0||(n=obstacleGrid[0].length)==0)return 0;
        int[] dp=new int[n];
        // 初始化第一层
        dp[0]=obstacleGrid[0][0]==0?1:0;
        for(int i=0;i<m;i++){
            dp[0]=obstacleGrid[i][0]==0?dp[0]:0;
            for(int j=1;j<n;j++){
                dp[j]=obstacleGrid[i][j]==0?dp[j]+dp[j-1]:0;
            }
        }
        return dp[n-1];

    }

    // 其实本题目可以使用空间复杂度On的算法完成,并不需要空间复杂度平方
    public int uniquePathsWithObstaclesOn2(int[][] obstacleGrid) {
        int m,n;
        if((m=obstacleGrid.length)==0||(n=obstacleGrid[0].length)==0)return 0;
        int[][] dp=new int[m][n];
        dp[0][0]=obstacleGrid[0][0]==0?1:0;
        for(int i=1;i<m;i++){
            dp[i][0]=obstacleGrid[i][0]==0?dp[i-1][0]:0;
        }
        for(int j=1;j<n;j++){
            dp[0][j]=obstacleGrid[0][j]==0?dp[0][j-1]:0;
        }

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                dp[i][j]=obstacleGrid[i][j]==0?(dp[i-1][j]+dp[i][j-1]):0;
            }
        return dp[m-1][n-1];

    }
}
