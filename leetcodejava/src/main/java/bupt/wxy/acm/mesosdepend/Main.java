package main.java.bupt.wxy.acm.mesosdepend;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 4/18/17.
 拓扑排序
 */
public class Main {

    int[][] weights;
    int[][] depend;
    boolean[][] visited;

    int k;

    public int res = Integer.MIN_VALUE;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] weight = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<= i; j++){
                weight[i][j] = in.nextInt();
            }
        }
        Main main = new Main(weight, k);
        main.backtracking(k, n-1, n-1, 0);
        System.out.println(main.res);
    }

    public Main(int[][] weight, int k){
        this.weights = weight;
        this.k = k;
        int n = weight.length;
        visited = new boolean[n][n];
        depend = new int[n][n];
        for(int i = 0; i<n-1; i++){
            for(int j=0;j<=i; j++){
                depend[i][j] = 2;
            }
        }
    }

    // 当前条件代表已经选到了 i, j, 还没有做出选择
    public void backtracking(int curr_k, int i, int j, int weight){
        if(i<0)return;
        if(j>i)return;
        // 首先向上遍历
        // 然后向右面遍历
        // 结束条件
        if(curr_k == k)res = Math.max(weight, res);
        // 不选择i, j, 没有任何影响
        // 向上
        backtracking(curr_k, i -1, j, weight);
        // 向前
        for(int k = j-1; k>=0; k--){
            backtracking(curr_k, i, k, weight);
        }

        // 如果条件允许, 可以选择i, j
        if(depend[i][j]!=0)return;
        // 选择i, j
        if(i!=0){
            if(j!=0) {
                depend[i - 1][j - 1]--;
            }
            if(i!=j){
                depend[i-1][j]--;
            }
        }
        weight += weights[i][j];
        // 向上
        backtracking(curr_k+1, i-1, j, weight);
        // 想钱
        for(int k = j-1; k>=0; k--){
            backtracking(curr_k+1, i, k, weight);
        }
        if(i!=0){
            if(j!=0) {
                depend[i - 1][j - 1]++;
            }
            if(i!=j){
                depend[i-1][j]++;
            }
        }
    }


}
