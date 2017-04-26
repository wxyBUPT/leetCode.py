package main.java.bupt.wxy.hihoCoder.mc2017.LegendaryItems;

import java.util.Scanner;

public class Other{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int N = sc.nextInt();
        double ret = 0.0;
        double dq = 1.0 * Q / 100;
        double[] val = new double[1005];
        for (int i = 0; i <= 100; i++) {
            val[i] = -1000;
        }
        for (int i = 0; i < N; i++) {
            if (val[P] == -1000) {
                val[P] = Other.calc(P, dq);
            }
            ret += val[P];
            P /= 2;
        }
        System.out.printf("%.2f\n", ret);
    }

    public static double calc(int p, double q) {
        double pp = 0.01 * p;
        double rtn = 1;
        double bef = 1;
        int j = 1;
        while (j<=100){
            bef *= (1 - pp);
            rtn += bef;
            pp += q;
            if (pp >= 1.0) {
                break;
            }
            j++;
        }

        return rtn;
    }

}
