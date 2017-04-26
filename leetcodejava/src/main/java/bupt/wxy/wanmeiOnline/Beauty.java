package main.java.bupt.wxy.wanmeiOnline;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 3/28/17.
 */
public class Beauty {
    static boolean[] isNarcissus = new boolean[1000];
    static {
        for(int i=100;i<1000; i++){
            if(isNarcissus(i))isNarcissus[i] = true;
        }
    }

    static boolean isNarcissus(int num){
        int cache = num;
        int res = 0;
        while (num!=0){
            int tmp = num % 10;
            num = num/10;
            res += tmp * tmp * tmp;
        }
        return res == cache;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m, n;

        while (in.hasNextInt()){
            m = in.nextInt();
            n = in.nextInt();

            boolean isFirst = true;
            for(int i=m; i<=n; i++){
                if(isNarcissus(i)){
                    if(isFirst) {
                        System.out.print(i);
                        isFirst = false;
                    }else {
                        System.out.print(" " + i);
                    }
                }
            }
            if(isFirst){
                System.out.print("no");
            }
            System.out.println();
        }
    }

}
