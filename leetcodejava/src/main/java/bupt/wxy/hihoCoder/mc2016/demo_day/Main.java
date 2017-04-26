package main.java.bupt.wxy.hihoCoder.mc2016.demo_day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();
        char[][] maze = new char[N][M];
        for(int i=0;i<N;i++){
            char[] chars = in.nextLine().toCharArray();
            for(int j=0;j<M;j++){
                maze[i][j] = chars[j];
            }
        }
        getMin(maze, N, M);

    }

    public static void getMin(char[][] maze, int N, int M){
        if(N==0||M==0)return;
        // 如果在当前位置方向向右需要改动最小的快数
        int[][] right = new int[N][M];
        if(maze[0][0]=='b')right[0][0] = 1;
        // 方向向下需要改变最小的数目
        int[][] bottom = new int[N][M];
        // 如果想让在这个位置有移动的可能, 必须清楚障碍
        if(maze[0][0]=='b'){
            right[0][0]++;
            bottom[0][0]++;
        }
        // 如果想向下移动, 则一定要设置障碍
        if(M!=1&&maze[0][1]=='.'){
            bottom[0][0]++;
        }

        for(int i=1;i<M;i++){
            if(maze[0][i]=='b'){
                right[0][i]++;
            }
            // 处理向右面走
            right[0][i]+=right[0][i-1];
            bottom[0][i]=right[0][i];
            if(i<M-1&&maze[0][i+1]=='.')bottom[0][i]++;

        }
        for(int j=1;j<N;j++){
            if(maze[j][0]=='b'){
                bottom[j][0]++;
            }
            bottom[j][0] += bottom[j-1][0];
            right[j][0] = bottom[j][0];
            if(j<N-1&&maze[j+1][0]=='.')right[j][0]++;
        }

        for(int i=1; i<N; i++){
            for(int j=1;j<M; j++){
                if(maze[i][j]=='b'){
                    right[i][j]++;
                    bottom[i][j]++;
                }
                // 求向右移动需要弄掉的最小石头块的数目
                int up = bottom[i-1][j];
                if(i<N-1&&maze[i+1][j]=='.')up++;
                int left = right[i][j-1];
                right[i][j] += Math.min(up, left);

                // 向下移动
                up = bottom[i-1][j];
                left = right[i][j-1];
                if(j<M-1&&maze[i][j+1]=='.')left++;
                bottom[i][j] += Math.min(up, left);
            }
        }
        System.out.println(Math.min(right[N-1][M-1], bottom[N-1][M-1]));
    }
}
