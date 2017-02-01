package main.java.bupt.wxy.graph;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/10/17.
 310. Minimum Height Trees
 Total Accepted: 26131
 Total Submissions: 91798
 Difficulty: Medium
 Contributors: Admin
 For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

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
 * 本题目的bfs超时,即使使用了监剪枝
 * 一层一层的去掉叶子节点, 最后剩下的就是根源最深的节点
 * 其实思想与层序遍历相同,
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
        }
        for(int[] edg:edges){
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }

        List<Integer> leaves=new ArrayList<>();
        for(int i=0;i<n;++i){
            if(adj.get(i).size()==1){
                leaves.add(i);
            }
        }

        while (n>2){
            // 移除所有leaves
            n-=leaves.size();
            List<Integer> newLeaves=new ArrayList<>();
            for(int i:leaves){
                int j=adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size()==1)newLeaves.add(j);
            }
            leaves=newLeaves;
        }
        return leaves;
    }
}
