package main.java.bupt.wxy.unionfind;

/**
 * Created by xiyuanbupt on 1/7/17.
 200. Number of Islands
 Difficulty: Medium
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

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

/**
 * 其实本题目可以使用dfs 和bfs解决,但是看到标签里面有unionfind, 所以借助于unionfind
 */
public class NumberOfIsLands{

    public int numIslands(char[][] grid) {

        int m,n;
        if((m=grid.length)==0||(n=grid[0].length)==0)return 0;
        UF uf=new UF(m, n, grid);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0')continue;
                int p=i*n+j;
                int q;
                if(i>0&&grid[i-1][j]=='1'){
                    q=p-n;
                    uf.union(p,q);
                }
                if(i<m-1&&grid[i+1][j]=='1'){
                    q=p+n;
                    uf.union(p,q);
                }
                if(j>0&&grid[i][j-1]=='1'){
                    q=p-1;
                    uf.union(p,q);
                }
                if(j<n-1&&grid[i][j+1]=='1'){
                    q=p+1;
                    uf.union(p,q);
                }
            }
        return uf.count;
    }
}

class UF{
    public int count=0;
    public int[] id=null;
    public UF(int m, int n, char[][] grid){
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1')count++;
            }
        id=new int[m*n];
        for(int i=0;i<m*n;i++){
            id[i]=i;
        }
    }

    public int find(int p){
        while (p!=id[p]){
            // 问题,为啥要改并查集呢, 我觉得是因为是二维的原因
            // 我想明白了, 是为了减少并查集的高度
            id[p]=id[id[p]];
            p=id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        return find(p)==find(q);
    }

    public void union(int p, int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot)return;
        id[pRoot]=qRoot;
        count--;
    }
}
