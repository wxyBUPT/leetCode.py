package main.java.bupt.wxy.dfs;

import java.util.*;

/**
 * Created by xiyuanbupt on 3/19/17.
 542. 01 Matrix
 Difficulty: Medium
 Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.
 Example 1:
 Input:

 0 0 0
 0 1 0
 0 0 0
 Output:
 0 0 0
 0 1 0
 0 0 0
 Example 2:
 Input:

 0 0 0
 0 1 0
 1 1 1
 Output:
 0 0 0
 0 1 0
 1 2 1
 Note:
 The number of elements of the given matrix will not exceed 10,000.
 There are at least one 0 in the given matrix.
 The cells are adjacent in only four directions: up, down, left and right.
 */
public class _01Matrix {

    // 下面算法是
    int m, n;
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if((m=matrix.size())==0||(n=matrix.get(0).size())==0)return res;
        int[][] map = new int[m][n];
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                map[i][j] = matrix.get(i).get(j);
                // 这里的0代表无穷远
                dist[i][j] = 0;
            }
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(map[i][j]==0)dfs(map, dist, 0, i, j);
            }
        for(int i=0;i<m;i++){
            List<Integer> list = new ArrayList<>(n);
            for(int num:dist[i]){
                list.add(num);
            }
            res.add(list);
        }
        return res;
    }

    private void dfs(int[][] map, int[][] dist, int curr_dist, int i, int j){
        dist[i][j] = curr_dist;
        // up
        if(i>0&&map[i-1][j]!=0&&(dist[i-1][j]==0||dist[i-1][j]>curr_dist+1))dfs(map, dist, curr_dist+1, i-1, j);
        // down
        if(i+1<m&&map[i+1][j]!=0&&(dist[i+1][j]==0||dist[i+1][j]>curr_dist+1))dfs(map, dist, curr_dist+1, i+1, j);
        // left
        if(j>0&&map[i][j-1]!=0&&(dist[i][j-1]==0||dist[i][j-1]>curr_dist+1))dfs(map, dist, curr_dist+1, i, j-1);
        // right
        if(j+1<n&&map[i][j+1]!=0&&(dist[i][j+1]==0||dist[i][j+1]>curr_dist+1))dfs(map, dist, curr_dist+1, i, j+1);
    }
}
