package main.java.bupt.wxy.hihoCoder.mc2015.MagicBox;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 3/30/17.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int[] diff = new int[3];
        diff[0] = in.nextInt();
        diff[1] = in.nextInt();
        diff[2] = in.nextInt();
        int[] cudiff = new int[3];
        Arrays.sort(diff);
        in.nextLine();
        int[] map = new int[3];

        int maxV = Integer.MIN_VALUE;
        String line = in.next();
        char[] chars = line.toCharArray();
        for(char c:chars){
            if(c=='R'){
                map[0] ++;
            }else if(c == 'B'){
                map[1] ++;
            }else {
                map[2] ++;
            }
            cudiff[0] = abs(map[0]-map[1]);
            cudiff[1] = abs(map[1]-map[2]);
            cudiff[2] = abs(map[2]-map[0]);
            Arrays.sort(cudiff);
            boolean equal = (diff[0] == cudiff[0] && diff[1] == cudiff[1] && diff[2] == cudiff[2]);
            if(equal){
                int count = 0;
                for(int i=0;i<3;i++){
                    count += map[i];
                    map[i] = 0;
                }
                maxV = max(count, maxV);
            }
        }
        int count = 0;
        for(int i=0;i<3;i++){
            count += map[i];
        }
        System.out.print(max(maxV,count));

}

    static int abs(int a){
        return a<0?-a:a;
    }
    static int max(int a, int b){
        return a>b?a:b;
    }
}
