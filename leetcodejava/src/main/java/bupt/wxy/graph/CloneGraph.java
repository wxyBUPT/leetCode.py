package main.java.bupt.wxy.graph;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/16/17.
 133. Clone Graph   Add to List QuestionEditorial Solution  My Submissions
 Difficulty: Medium

 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */

public class CloneGraph {

    // 64.83%
    Map<UndirectedGraphNode,UndirectedGraphNode> seen;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        seen=new HashMap<>();
        return dfs(node);
    }

    UndirectedGraphNode dfs(UndirectedGraphNode node){
        if(node==null)return node;
        if(seen.containsKey(node))return seen.get(node);

        UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
        seen.put(node,newNode);
        for(UndirectedGraphNode neighbor:node.neighbors){
            // 如果节点已经创建
            newNode.neighbors.add(dfs(neighbor));
        }
        return newNode;
    }
}


class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
};