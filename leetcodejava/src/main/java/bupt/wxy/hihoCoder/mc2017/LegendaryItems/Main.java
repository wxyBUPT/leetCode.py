package main.java.bupt.wxy.hihoCoder.mc2017.LegendaryItems;

import java.util.Scanner;

public class Main {
    int P, Q, N;
    public Main(int p, int q, int n){
        P = p;
        Q = q;
        N = n;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        int Q = in.nextInt();
        int N = in.nextInt();
        Main main = new Main(P, Q, N);
        double left = main.buildTree(1, 1, P, P/100.0, true);
        double right = main.buildTree(1, 0, 100-P, (100-P)/100.0, false);
        System.out.println(left + right);
    }

    /**
     * @param height 这个节点的高度
     * @param currLegendaryCount 这个节点能够获得的数量
     * @param posibility 从父亲走到这个节点的可能性
     * @param totalPos 总的走到这个节点的可能性
     * @param gain 当前节点是否获得
     * @return
     */
    public double buildTree(int height, int currLegendaryCount, int posibility,double totalPos, boolean gain){
        if(posibility==0)return 0.0;
        // 已经获得, 不再遍历
        if(currLegendaryCount == N){
            return height * totalPos;
        }
        double left, right;
        if(gain){
            int tmp = 1;
            for(int i=0; i<currLegendaryCount;i++)tmp *= 2;
            int left_posibility = P/tmp;
            int right_posibility = 100 - left_posibility;
            left = buildTree(height + 1, currLegendaryCount + 1, left_posibility, totalPos * (left_posibility / 100.0), true);
            right = buildTree(height + 1, currLegendaryCount, right_posibility, totalPos * (right_posibility / 100.0), false);
        }
        else {
            int left_posibility = posibility + Q;
            left_posibility = Math.min(left_posibility ,100);
            int right_posibility = 100 - left_posibility;
            left = buildTree(height + 1, currLegendaryCount + 1, left_posibility, totalPos * (left_posibility / 100.0), true);
            right = buildTree(height + 1, currLegendaryCount, right_posibility, totalPos * (right_posibility / 100.0), false);
        }
        return left + right;
    }
}
