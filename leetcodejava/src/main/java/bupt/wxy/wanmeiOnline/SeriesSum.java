package bupt.wxy.wanmeiOnline;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 3/28/17.

 */
public class SeriesSum {
    private static double getSum(int n, int m){

        double tmp = n / 1.0;
        double res = 0.0;
        while (m>0){
            m--;
            res += tmp;
            tmp = Math.sqrt(tmp);
        }
        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 0, m = 0;
        while (in.hasNext()){
            n = in.nextInt();
            m = in.nextInt();
            System.out.format("%.2f", getSum(n, m));
            System.out.println();
        }
    }
}
