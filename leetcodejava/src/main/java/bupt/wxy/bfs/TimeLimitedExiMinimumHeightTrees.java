package main.java.bupt.wxy.bfs;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/10/17.
 310. Minimum Height Trees
 Difficulty: Medium

 For a undirected graph with tree characteristics, we can choose any node as the root.
 The result graph is then a rooted tree. Among all possible rooted trees,
 those with minimum height are called minimum height trees (MHTs).
 Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]

 Hint:

 How many MHTs can a graph have at most?
 Note:

 (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

 (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */

/**
 * 一般考到了图
 */
public class TimeLimitedExiMinimumHeightTrees {

    boolean[] visited;
    int[][] path;
    int n;

    // 以下方法不管怎么剪枝都是会超时
    public List<Integer> findMinHeightTreesBad(int n, int[][] edges) {
        this.n=n;
        visited=new boolean[n];
        path=new int[n][n];
        for(int[] edge:edges){
            path[edge[0]][edge[1]]=1;
            path[edge[1]][edge[0]]=1;
        }

        int min_depth=n;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            // 所有的叶子节点肯定不可能是答案
            int child=0;
            for(int j=0;j<path.length;j++){
                if(path[i][j]==1)child++;
            }
            int depth;
            if(child==1) {
                depth = n;
            }
            else {
                for (int j = 0; j < visited.length; j++) visited[j] = false;
                depth = dfs(i, min_depth);
            }
            if(depth<min_depth){
                min_depth=depth;
                res=new LinkedList<>();
                res.add(i);
            }
            else if(depth==min_depth)res.add(i);
        }
        return res;
    }

    // 需要保证i节点没有被遍历
    // 如果深度已经超过max,就不要再遍历了
    int dfs(int node, int max){
        int depth=1;
        int child=0;
        visited[node]=true;
        for(int i=0;i<n;i++){
            if(i==node)continue;
            if(!visited[i]&&path[node][i]==1)child=Math.max(child,dfs(i,max-1));
            if(child>max-1)return Integer.MAX_VALUE;
        }
        return depth+child;
    }
}
