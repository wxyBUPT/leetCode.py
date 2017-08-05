package main.java.bupt.wxy.indeed.round2.Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 5/13/17.
 */


/**
 * 典型的回溯法剪枝
 */
public class Fuck{

    static int res = 0;
    static int[][] effi;
    static int  N, K, M;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();
        M = in.nextInt();

        effi = new int[N+1][N+1];
        for(int i = 0;i<M;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int u = in.nextInt();
            effi[a][b] = u;
            effi[b][a] = u;
        }
        backtracking(1, new ArrayList<>(K+1), new ArrayList<>(K+1), 0, 0);
        System.out.println(res);
    }

    /**
     * 01背包问题
     * @param i
     * @param fir
     * @param sec
     * @param fireff
     * @param seceff
     */
    static void backtracking(int i, List<Integer> fir, List<Integer> sec, int fireff, int seceff){
        int f_len = fir.size(), s_len = sec.size();
        if(f_len>K || s_len > K)return;
        if(f_len == K && s_len == K){
            res = Math.max(res, fireff + seceff);
            return;
        }
        if(f_len == K){
            res = Math.max(res, fireff);
        }
        if(s_len == K){
            res = Math.max(res, seceff);
        }

        // 没有必要再选下去
        if(i>N)return;
        // 不选i
        backtracking(i+1, fir, sec, fireff, seceff);

        // i放入fir
        int fir_next_eff = fireff;
        for(Integer e:fir){
            fir_next_eff += effi[e][i];
        }
        fir.add(i);
        backtracking(i+1, fir, sec, fir_next_eff , seceff);
        fir.remove(fir.size()-1);
        // i放入sec

        for(Integer e:sec){
            seceff += effi[e][i];
        }

        sec.add(i);
        backtracking(i+1, fir, sec, fireff, seceff);
        sec.remove(sec.size() - 1);
    }
}