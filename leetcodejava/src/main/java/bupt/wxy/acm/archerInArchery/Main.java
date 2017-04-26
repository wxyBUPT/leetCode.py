package main.java.bupt.wxy.acm.archerInArchery;

import java.util.Scanner;

public class Main {

    // Greedy
    // First use greedy to get may ans for future prune
    int getBoarder(boolean[] shooted, int[] heights, int[] speeds, int n){
        int res = Integer.MIN_VALUE;
        int remain = n;
        while (remain>0){
            remain--;
            int[] nexts = new int[n];
            int maxIndex = -1;
            for(int i=0;i<n;i++){
                if(!shooted[i]){
                    nexts[i]=heights[i]+speeds[i];
                    if(maxIndex==-1)maxIndex=i;
                    else {
                        maxIndex = nexts[maxIndex]>nexts[i]?maxIndex:i;
                    }
                }

            }
            res = Math.max(heights[maxIndex],res);
            shooted[maxIndex] = true;
            heights = nexts;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int T = in.nextInt();
        while (T>0){
            T--;
            int N = in.nextInt();
            int[] heights = new int[N];
            int[] speeds = new int[N];
            for(int i=0;i<N;i++)heights[i] = in.nextInt();
            for(int i=0;i<N;i++)speeds[i] = in.nextInt();
            boolean[] shooted = new boolean[N];
            System.out.println(main.getBoarder(shooted, heights, speeds, N));
        }
    }
}
