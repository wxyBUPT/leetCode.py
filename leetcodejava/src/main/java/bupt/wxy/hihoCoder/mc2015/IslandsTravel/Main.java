package main.java.bupt.wxy.hihoCoder.mc2015.IslandsTravel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Dijkstra
 */

public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt();
        int[] x_i = new int[N];
        int[] y_j = new int[N];
        int[][] paths = new int[N][N];
        for(int i=0;i<N;i++){
            x_i[i] = in.nextInt();
            y_j[i] = in.nextInt();
        }
        for(int i=0;i<N;i++) {
            for (int j = i+1; j < N; j++) {
                if (i == j) continue;
                int dist = min(abs(x_i[i] - x_i[j]) , abs(y_j[i] - y_j[j]));
                paths[i][j] = dist;
                paths[j][i] = dist;
            }
        }

        // use dijkstra calculate the min dist
        int[] dist = new int[N];
        dist[0] = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N];
        for(int i=1;i<N;i++){
            dist[i] = paths[0][i];
        }
        while (!visited[N-1]){
            // find min dist
            int min_index = 0;
            for(int i=1;i<N;i++){
                if(!visited[i]&&dist[i]<dist[min_index])min_index=i;
            }

            visited[min_index] = true;

            for(int i=1;i<N;i++){
                if(!visited[i] && dist[min_index] + paths[min_index][i] < dist[i]){
                    dist[i] = dist[min_index] + paths[min_index][i];
                }
            }
        }
        System.out.print(dist[N-1]);
    }

    static int min(int a, int b){
        return a>b?b:a;
    }

    static int abs(int a){
        return a>0?a:-a;
    }
}
