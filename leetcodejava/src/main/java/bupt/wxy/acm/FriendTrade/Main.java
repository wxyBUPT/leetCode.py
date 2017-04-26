package main.java.bupt.wxy.acm.FriendTrade;

import java.util.Scanner;

public class Main {

    static public void getFriendsCount(int[][] paths){
        int n = paths.length-1;
        int[] count = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=n; j++){
                if(paths[i][j]==1 && i!=j){ // i j has direct relation
                    for(int k=i+1; k<=n; k++){
                        if(paths[j][k]==1&&paths[k][i]==0){ // j has relation with k && k don't has relation with i && k is not i
                            count[k]++;
                            count[i]++;
                        }
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            System.out.println(count[i]);
        }
    }

    public static void main(String[] args){
        System.out.println("hello world");
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T>0){
            T--;
            int n = in.nextInt();
            int m = in.nextInt();
            int i, j;
            int[][] paths = new int[n+1][n+1];
            for(int k=1;k<=n;k++){
                paths[k][k] = 1;
            }
            while (m>0){
                m--;
                i = in.nextInt();
                j = in.nextInt();
                paths[i][j] = paths[j][i] = 1;
            }
            getFriendsCount(paths);
        }
    }
}
