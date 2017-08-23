package bupt.wxy.wangyi.Q2;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 8/12/17.
 */
public class Main {

    static int[] x_pos;
    static int[] y_pos;
    static int n;
    static int curr_min;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        x_pos = new int[n];
        y_pos = new int[n];
        for(int i = 0; i<n; i++){
            x_pos[i] = in.nextInt();
        }
        for(int i = 0; i<n; i++){
            y_pos[i] = in.nextInt();
        }

        for(int i = 0; i<n; i++){
            curr_min = Integer.MAX_VALUE;
            for(int j = 0; j<n; j++){ // 移动到第 j 个点
                getMoveCount(x_pos[j], y_pos[j], i + 1, 0, 0);
            }
            System.out.print(curr_min);
            if(i != n - 1)System.out.print(" ");
        }
    }

    public static void getMoveCount(int x, int y, int count, int curr_cost, int pos){
        if(count == 0){ // 不需要再选点了
            curr_min = Math.min(curr_cost, curr_min);
            return;
        }
        if(pos == n){ // 没有点可以选了
            return;
        }

        for(int i = pos; i<n; i++){ // 选每一个
            int next_cost = curr_cost + Math.abs(x - x_pos[i]) + Math.abs(y - y_pos[i]);
            getMoveCount(x, y, count - 1, next_cost, i + 1);
        }
    }
}
