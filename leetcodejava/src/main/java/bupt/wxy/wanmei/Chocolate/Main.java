package main.java.bupt.wxy.wanmei.Chocolate;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 3/29/17.
 *题目描述：
 贪吃鬼小R买了一些巧克力，小R每天吃一半，但是还不过瘾，还又多吃三块，就这样小R每天都是吃前天剩下的一半零三块，直到最后一天就剩一块巧克力可以吃。请帮小R算算如果是这个节奏吃，吃N天需要买多少块巧克力
 */
public class Main {

    public long getNDayCount(int n){
        if(n<1)return 0;
        long res = 1;
        while (n>1){
            n--;
            res = res + 3;
            res *= 2;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int n = 0;
        while (in.hasNextInt()){
            n = in.nextInt();
            System.out.println(main.getNDayCount(n));
        }
    }
}
