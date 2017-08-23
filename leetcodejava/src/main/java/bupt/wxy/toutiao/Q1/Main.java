package bupt.wxy.toutiao.Q1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 8/22/17.
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] points = new int[n][2];
        int len = 0;
        int y_max = Integer.MIN_VALUE, x_max = Integer.MIN_VALUE;
        int x, y;
        for(int i = 0; i<n; i++){
            x = in.nextInt();
            y = in.nextInt();
            if(x < x_max && y<y_max){

            }else {
                points[len][1] = y;
                points[len][0] = x;
                len ++;
                x_max = Math.max(x_max, x);
                y_max = Math.max(y_max, y);
            }
        }

        Arrays.sort(points, 0, len - 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            };
        });

        int z_max = Integer.MIN_VALUE;
        for(int[] point:points){
            if(point[1] > z_max){
                System.out.println(point[1]);
                System.out.println(" ");
                System.out.println(point[0]);
                System.out.println();
                z_max = point[1];
            }
        }
    }
}
