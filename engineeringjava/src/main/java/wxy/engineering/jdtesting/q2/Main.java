package wxy.engineering.jdtesting.q2;

import java.util.*;

/**
 * Created by xiyuanbupt on 4/7/17.
 题目描述：
 小明同学要参加一场考试，考试一共有n道题目，小明必须做对至少60%的题目才能通过考试。考试结束后，小明估算出每题做对的概率，p1,p2,...,pn。你能帮他算出他通过考试的概率吗？
 输入
 输入第一行一个数n（1<=n<=100），表示题目的个数。第二行n个整数，p1,p2,...,pn。表示小明有pi%的概率做对第i题。（0<=pi<=100）
 输出
 小明通过考试的概率，最后结果四舍五入，保留小数点后五位。

 样例输入
 4
 50 50 50 50
 样例输出
 0.31250

 Hint
 第一个样例中，每道题做对的概率都是0.5，想要通过考试至少要做对三题。所以最后的答案就是。

 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        double[] rates = new double[n + 1];
        for(int i=1,len = n+1;i<len; i++){
            int r = in.nextInt();
            rates[i] = r / 100.0;
        }

        int k = (int)Math.ceil(n * 0.6);
        calculate(rates, k, n);
    }

    static void calculate(double[] rates, int k, int n){
        double[][] dp = new double[n+1][k+1];
        dp[0][0] = 1.0;
        for(int i=1;i<n+1;i++){
            dp[i][0] = dp[i-1][0] * (1-rates[i]);
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                dp[i][j] = dp[i-1][j] * (1.0 - rates[i]) + dp[i-1][j-1] * rates[i] ;
            }
        }

        double res = 0.0;
        for(int i=0; i<k;i++){
            res += dp[n][i];
        }
        System.out.print(String.format("%.5f", 1.0 - res));
    }
}
