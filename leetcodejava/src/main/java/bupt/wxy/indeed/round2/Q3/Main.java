package main.java.bupt.wxy.indeed.round2.Q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 5/13/17.
 */
public class Main {
    static int H, W, D, R;
    static char[][] maze;
    static int[][] normal;
    static int[][] warp;
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        H = in.nextInt(); W = in.nextInt(); D = in.nextInt(); R = in.nextInt();
        in.nextLine();
        maze = new char[H][W];
        for(int i = 0; i<H; i++){
            char[] chars = in.nextLine().toCharArray();
            System.arraycopy(chars, 0, maze[i], 0, chars.length);
        }
        System.out.println(solve());
    }

    static void dfs(int i, int j){
        // from normal
        int next_normal = (normal[i][j]==Integer.MAX_VALUE? Integer.MAX_VALUE:(normal[i][j] + 1));
        int next_warp = (warp[i][j]==Integer.MAX_VALUE?Integer.MAX_VALUE:(warp[i][j]+1));

        if(canGo(i-1, j) ){
            if(normal[i-1][j] > next_normal){
                normal[i - 1][j] = next_normal;
                dfs(i - 1, j);
            }
            if(warp[i-1][j]>next_warp){
                warp[i-1][j] = next_warp;
                dfs(i-1, j);
            }
        }
        if(canGo(i+1, j)){
            if( normal[i+1][j] > next_normal){
                normal[i + 1][j] = next_normal;
                dfs(i + 1, j);
            }
            if(warp[i+1][j]>next_warp){
                warp[i+1][j] = next_warp;
                dfs(i+1, j);
            }
        }
        if(canGo(i, j-1) ){
            if(normal[i][j-1] > next_normal){
                normal[i][j - 1] = next_normal;
                dfs(i, j - 1);
            }
            if(warp[i][j-1]>next_warp){
                warp[i][j-1]= next_warp;
                dfs(i, j-1);
            }
        }

        if(canGo(i, j+1)  ){
            if(normal[i][j+1] > next_normal) {
                normal[i][j + 1] = next_normal;
                dfs(i, j + 1);
            }
            if(warp[i][j+1]>next_warp){
                warp[i][j+1] = next_warp;
                dfs(i, j+1);
            }
        }

        if(canGo(i+D, j+R) && warp[i+D][j+R] > next_normal){
            warp[i+D][j+R] = next_normal;
            dfs(i+D, j+R);
        }
    }

    static boolean canGo(int i, int j){
        return !(i<0 || i>=H || j<0 || j>=W)&&maze[i][j] == '.';
    }


    static int solve(){
        normal = new int[H][W];
        warp = new int[H][W];
        for(int i = 0;i<H; i++){
            for(int j = 0; j<W; j++){
                normal[i][j] = Integer.MAX_VALUE;
                warp[i][j] = Integer.MAX_VALUE;
            }
        }
        normal[0][0] = 0;
        warp[0][0] = 0;
        dfs(0, 0);
        int min = Integer.min(normal[H-1][W-1], warp[H-1][W-1]);
        return min == Integer.MAX_VALUE ? -1: min;
    }
}
