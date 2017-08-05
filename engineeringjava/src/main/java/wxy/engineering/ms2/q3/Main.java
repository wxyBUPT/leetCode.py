package wxy.engineering.ms2.q3;

/**
 * Created by xiyuanbupt on 4/8/17.
 描述
 Little Hi has a box which consists of 2xN cells as illustrated below.

 +----+----+----+----+----+----+
 | A1 | A2 | A3 | A4 | .. | AN |
 +----+----+----+----+----+----+
 | B1 | B2 | B3 | B4 | .. | BN |
 +----+----+----+----+----+----+
 There are some coins in each cell. For the first row the amounts of coins are A1, A2, ... AN and for the second row the amounts are B1, B2, ... BN.

 Each second Little Hi can pick one coin from a cell and put it into an adjacent cell. (Two cells are adjacent if they share a common side. For example, A1 and A2 are adjacent; A1 and B1 are adjacent; A1 and B2 are not adjacent.)

 Now Little Hi wants that each cell has equal number of coins by moving the coins. He wants to know the minimum number of seconds he needs to accomplish it.

 输入
 The first line contains an integer, N. 2 <= N <= 100000

 Then follows N lines. Each line contains 2 integers Ai and Bi. (0 <= Ai, Bi <= 2000000000)

 It is guaranteed that the total amount of coins in the box is no more than 2000000000 and is a multiple of 2N.

 输出
 The minimum number of seconds.

 样例输入
 2
 3 4
 6 7
 样例输出
 4
 */

import java.util.Scanner;

/**
 * 从头开始
 * 都不够的从后面补, (只要遇到多的就向前补上去)
 * 多余的记录remain
 * 价格下一个
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        long sum = 0;
        for(int i = 0;i<n;i++){
            A[i] = in.nextInt();
            B[i] = in.nextInt();
            sum += (A[i] + B[i]);
        }
        long res = solve(A, B, (int)(sum/(2*n)), n);
        System.out.print(res);
    }

    public static long solve(int[] A, int[] B, int aver, int n){
        long res = 0;
        int a_reamin = 0, b_remain=0;
        for(int i=0;i<n-1;i++){
            // 前面剩下的向后走
            res += (a_reamin + b_remain);
            if(A[i]<aver){
                // 从前面的补
                A[i] = A[i] + a_reamin;
            }
            if(B[i]<aver){
                B[i] = B[i] + b_remain;
            }

            // 两个可以做一个互补
            boolean a_m = A[i] > aver;
            boolean b_m = B[i] > aver;
            if(a_m && b_m){
                a_reamin = A[i] - aver;
                b_remain = B[i] - aver;
                continue;
            }else if(a_m){ // A多, 但是B少
                int a_more = A[i] - aver;
                int b_less = aver - B[i];
                if(a_more<b_less){
                    A[i] = aver;
                    B[i] += a_more;
                    res += a_more;
                }
                else {
                    a_reamin = a_more - b_less;
                    res += b_less;
                    b_remain = 0;
                    continue;
                }
            }else if(b_m){
                int b_more = B[i] - aver;
                int a_less = aver - B[i];
                if(b_more<a_less){
                    B[i] = aver;
                    A[i] += b_more;
                    res += b_more;
                }else {
                    b_remain = b_more - a_less;
                    res += a_less;
                    a_reamin = 0;
                    continue;
                }
            }
            // 开始向后面求石头
            int a_less = aver - A[i];
            int b_less = aver - B[i];
            res += a_less + b_less;
            A[i+1] -= a_less;
            B[i+1] -= b_less;
        }

        res += Math.abs(A[n-1] - aver);
        return res;
    }
}
