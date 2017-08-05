package bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 1/15/17.
 329. Longest Increasing Path in a Matrix
 Difficulty: Hard

 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 Credits:
 */
public class LongestIncreasingPathInAMatrix {

    // 使用最笨的dfs,
    // 51.52 % 但是传说中使用dfs不当会造成超时
    // 其他解法都差不多
    int[][] visited;
    int m,n;

    public int longestIncreasingPath(int[][] matrix) {

        if((m=matrix.length)==0||(n=matrix[0].length)==0)return 0;
        visited=new int[m][n];
        int res=Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(visited[i][j]==0){
                    dfs(matrix,i,j);
                }
                res=Math.max(res,visited[i][j]);
            }
        }
        return res;
    }

    void dfs(int[][] matrix,int i,int j){
        int right=0,left=0,bot=0,top=0;
        if(i>0&&matrix[i-1][j]<matrix[i][j]){
            if(visited[i-1][j]==0)dfs(matrix,i-1,j);
            left=visited[i-1][j];
        }
        if(i<m-1&&matrix[i+1][j]<matrix[i][j]){
            if(visited[i+1][j]==0)dfs(matrix,i+1,j);
            right=visited[i+1][j];
        }
        if(j>0&&matrix[i][j-1]<matrix[i][j]){
            if(visited[i][j-1]==0)dfs(matrix,i,j-1);
            top=visited[i][j-1];
        }
        if(j<n-1&&matrix[i][j+1]<matrix[i][j]){
            if(visited[i][j+1]==0)dfs(matrix,i,j+1);
            bot=visited[i][j+1];
        }
        visited[i][j]=Math.max(Math.max(right,left),Math.max(bot,top))+1;

    }

}
