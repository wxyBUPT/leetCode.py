package main.java.wxy.engineering.ljava;

import java.util.*;

public class Main{
    static int n;

    public static void main(String[] args){
        System.out.print(Long.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            String line = in.nextLine();
            for(int j=0;j<n;j++){
                if(line.charAt(j)=='B')matrix[j][i]=1;
                else matrix[j][i]=0;
            }
        }
        System.out.print(getMax(matrix));
    }


    // 求每一行最长连续
    static int getMax(int[][] matrix){
        for(int[] line:matrix){
            for(int i:line){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        if(n==0)return 0;
        int res = 0;
        for(int[] line:matrix){
            int curr = 1;
            for(int i=1;i<n;i++){
                if(line[i]==line[i-1])curr++;
                else {
                    res = Math.max(curr, res);
                    curr = 1;
                }
            }
            res = Math.max(curr, res);
        }
        return res;
    }
}
