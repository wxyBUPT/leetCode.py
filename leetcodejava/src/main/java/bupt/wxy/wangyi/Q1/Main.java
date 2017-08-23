package bupt.wxy.wangyi.Q1;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 8/12/17.
 */
public class Main {

    public static void main(String[] args){
        int x, f, d, p;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        f = sc.nextInt();
        d = sc.nextInt();
        p = sc.nextInt();
        int res = 0;
        int dayCost = 0;
        if(f > 0){
            dayCost = x;
            f -= 1;
        }else {
            dayCost = x + p;
        }
        while (d >= dayCost){
            res ++;
            d -= dayCost;
            if(f > 0){
                dayCost = x;
                f -= 1;
            }else {
                dayCost = x + p;
            }
        }
        System.out.println(res);
    }
}
