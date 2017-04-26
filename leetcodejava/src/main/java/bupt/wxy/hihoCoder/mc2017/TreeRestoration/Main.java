package main.java.bupt.wxy.hihoCoder.mc2017.TreeRestoration;

import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int node_count = in.nextInt();
        int level_count = in.nextInt();
        int leaf_count = in.nextInt();
        int[] parent = new int[node_count + 1];
        int[] level_leaf_count = new int[level_count];
        for(int i=0;i<level_count;i++){
            level_leaf_count[i] = in.nextInt();
        }
        List<List<Integer>> trees = new ArrayList<>(level_count);
        for(int i=0;i<level_count;i++){
            List<Integer> this_level = new ArrayList<>(level_leaf_count[i]);
            for(int j=0;j<level_leaf_count[i];j++){
                this_level.add(in.nextInt());
            }
            trees.add(this_level);
        }

        Set<Integer> leaf_set = new HashSet<>();
        int[] all_leafs = new int[leaf_count];
        for(int i=0;i<leaf_count;i++){
            all_leafs[i]=in.nextInt();
            leaf_set.add(all_leafs[i]);
        }
        // 用于保存leaf对应的 level
        Map<Integer, Integer> leaf_level = new HashMap<>();
        for(int i = 0;i<level_count;i++){
            for(Integer nodes :trees.get(i)){
                if(leaf_set.contains(nodes)){
                    leaf_level.put(nodes, i);
                }
            }
        }

        int[][] leaf_dists = new int[leaf_count][leaf_count];
        for(int i=0;i<leaf_count;i++){
            for(int j=0;j<leaf_count;j++){
                leaf_dists[i][j] = in.nextInt();
            }
        }

        int[] consumed_index = new int[level_count];

        // 初始化
        for(int i=level_count-1;i>0;i--){
            parent[trees.get(i).get(0)] = trees.get(i-1).get(0);
        }

        int i=0, j=1;
        while (j<leaf_count){
            // 通过 i j 的距离来计算对应的parent
            int i_level = leaf_level.get(all_leafs[i]);
            int j_level = leaf_level.get(all_leafs[j]);
            int dist_i_j = leaf_dists[i][j];

            int common_parent_level;
            if(i_level==j_level){
                common_parent_level = i_level - (dist_i_j/2);
                for(int k=j_level;k>common_parent_level;k--){

                    consumed_index[k]++;
                }
            }else if(i_level<j_level){

            }else {

            }
        }
    }
}
