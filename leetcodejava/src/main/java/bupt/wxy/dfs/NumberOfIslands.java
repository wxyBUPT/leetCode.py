package bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 1/7/17.
 200. Number of Islands
 Difficulty: Medium

 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class NumberOfIslands {

    // 这个算法利用了额外的空间,其实不需要额外的空间就能完成本算法
    public int numIslandsbad(char[][] grid) {
        int row=grid.length;
        if(row==0)return 0;
        int col=grid[0].length;
        if(col==0)return 0;
        boolean[][] visited=new boolean[row][col];
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    ans++;
                    dfs_visit(grid, visited, i, j, row, col);
                }
            }
        }
        return ans;
    }

    // dfs 访问一块陆地,并将访问标记设置为True
    void dfs_visit(char[][] grid, boolean[][] visited, int i, int j, int row, int col){
        visited[i][j]=true;
        if(i-1>-1&&grid[i-1][j]=='1'&&!visited[i-1][j])dfs_visit(grid,visited,i-1,j,row,col);
        if(i+1<row&&grid[i+1][j]=='1'&&!visited[i+1][j])dfs_visit(grid,visited,i+1,j,row,col);
        if(j-1>-1&&grid[i][j-1]=='1'&&!visited[i][j-1])dfs_visit(grid,visited,i,j-1,row,col);
        if(j+1<col&&grid[i][j+1]=='1'&&!visited[i][j+1])dfs_visit(grid,visited,i,j+1,row,col);
    }

    // 该共享的变量要共享啊
    int m=0;
    int n=0;

    public int numIslands(char[][] grid){
        m=grid.length;
        if(m==0)return 0;
        n=grid[0].length;
        if(n==0)return 0;
        int count=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfsVisit(grid,i,j);
                    ++count;
                }
            }
        return count;
    }

    void dfsVisit(char[][] grid, int i, int j){
        if(i<0||j<0||i==m||j==n||grid[i][j]!='1')return;
        grid[i][j]='0';
        dfsVisit(grid,i-1,j);
        dfsVisit(grid,i+1,j);
        dfsVisit(grid,i,j+1);
        dfsVisit(grid,i,j-1);
    }
    // bfs 算法量要多一些
}
