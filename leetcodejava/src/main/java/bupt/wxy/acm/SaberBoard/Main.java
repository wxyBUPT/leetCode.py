package main.java.bupt.wxy.acm.SaberBoard;

import java.util.Scanner;

public class Main {

    public int howMany(int n, int[][] board, int N, int M, int K){
        int res = 0;
        for(int i=0;i<N; i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==n&&isValid(i, j, board, N, M, K))res ++;
            }
        }
        return res;
    }

    public boolean isValid(int i, int j, int[][] board, int N, int M, int K){
        int intercept = K-1;
        for(int k = 0; k<N; k++){
            for(int l=0;l<M;l++){
                if(Math.abs(k-i) + Math.abs(l-j) <= intercept){
                    if(board[i][j]!=board[k][l])return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Main main = new Main();
        while (T>0){
            T--;
            int N = in.nextInt();
            int M = in.nextInt();
            int K = in.nextInt();
            int[][] board = new int[N][M];
            for(int i=0;i<N;i++){
                String line = in.nextLine();
                int j=0;
                for(char c:line.toCharArray()){
                    if(c=='X')board[i][j++] = 1;
                    else board[i][j++] = 0;
                }
            }
            System.out.println(main.howMany(1, board, N, M, K));
            System.out.println(main.howMany(0, board, N, M, K));
        }
    }

}
