package main.java.bupt.wxy.array;

/**
 * Created by xiyuanbupt on 1/3/17.
 48. Rotate Image   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 92293
 Total Submissions: 249300
 Difficulty: Medium
 Contributors: Admin
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class Solution_48 {

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        if(n==0)return;
        int[][] tmp=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                tmp[j][n-1-i]=matrix[i][j];
            }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matrix[i][j]=tmp[i][j];
    }
}