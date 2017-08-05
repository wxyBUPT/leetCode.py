package wxy.engineering.jdtesting.q3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 题目描述

 公司最近新研发了一种产品，共生产了n件。有m个客户想购买此产品，第i个客户出价Vi元。为了确保公平，公司决定要以一个固定的价格出售产品。每一个出价不低于要价的客户将会得到产品，余下的将会被拒绝购买。请你找出能让公司利润最大化的售价。


 输入
 输入第一行二个整数n(1<=n<=1000),m(1<=m<=1000)，分别表示产品数和客户数。
 接下来第二行m个整数Vi(1<=Vi<=1000000)，分别表示第i个客户的出价。
 样例输入
 5 4
 2 8 10 7
 输出
 输出一行一个整数，代表能够让公司利润最大化的售价。
 样例输出
 7
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] prices = new Integer[m];
        for(int i=0;i<m;i++){
            prices[i] = in.nextInt();
        }
        solve(prices, n, m);
    }

    public static void solve(Integer[] prices, int n, int m){
        Arrays.sort(prices, Collections.reverseOrder());
        int res = prices[0];
        long max = res;
        for(int i=1; i<n && i<m; i++){
            int curr_price = prices[i];
            if(curr_price * (i+1) > max){
                max = curr_price * (i+1);
                res = curr_price;
            }
        }
        System.out.print(res);
    }
}
