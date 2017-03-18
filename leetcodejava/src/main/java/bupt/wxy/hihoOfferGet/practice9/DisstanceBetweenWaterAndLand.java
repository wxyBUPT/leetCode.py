package main.java.bupt.wxy.hihoOfferGet.practice9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 3/12/17.
 描述
 给定一个N x M的01矩阵，其中1表示陆地，0表示水域。对于每一个位置，求出它距离最近的水域的距离是多少。

 矩阵中每个位置与它上下左右相邻的格子距离为1。

 输入
 第一行包含两个整数，N和M。

 以下N行每行M个0或者1，代表地图。

 数据保证至少有1块水域。

 对于30%的数据，1 <= N, M <= 100

 对于100%的数据，1 <= N, M <= 800

 输出
 输出N行，每行M个空格分隔的整数。每个整数表示该位置距离最近的水域的距离。

 样例输入
 4 4
 0110
 1111
 1111
 0110
 样例输出
 0 1 1 0
 1 2 2 1
 1 2 2 1
 0 1 1 0
 */

public class DisstanceBetweenWaterAndLand {

    // 对于每一块水, 使用dfs遍历
    int m, n;
    public int[][] getDist(int[][] map){

        if((m=map.length)==0||(n=map[0].length)==0)return null;
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                res[i][j]=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==0)dfsVisit(map, res, i, j, -1);
            }
        }
        /**
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==0)res[i][j]=0;
            }
        }
         **/
        return res;
    }

    private void dfsVisit(int[][] map, int[][] res, int i, int j, int pre){
        if(i<0||i>=m||j<0||j>=n||res[i][j]<=pre+1)return;
        res[i][j]=pre+1;
        dfsVisit(map, res, i-1, j, pre+1);
        dfsVisit(map, res, i+1, j, pre+1);
        dfsVisit(map, res, i, j-1, pre+1);
        dfsVisit(map, res, i, j+1, pre+1);
    }



    public static void main(String[] args){

        ArrayList<Integer> inputs = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        int m,n;
        String line=in.nextLine();
        int index=line.indexOf(" ");
        m=Integer.parseInt(line.substring(0,index).trim());
        n=Integer.parseInt(line.substring(index+1).trim());
        int[][] map=new int[m][n];
        for(int i=0;i<m;i++) {
            line=in.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(line.substring(j,j+1));
            }
        }

        DisstanceBetweenWaterAndLand disstanceBetweenWaterAndLand=new DisstanceBetweenWaterAndLand();
        int[][] res=disstanceBetweenWaterAndLand.getDist(map);
        for(int[] l:res){
            for(int r:l){
                System.out.print(r);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
