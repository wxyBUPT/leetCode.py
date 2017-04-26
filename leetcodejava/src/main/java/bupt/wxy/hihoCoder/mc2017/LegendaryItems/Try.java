package main.java.bupt.wxy.hihoCoder.mc2017.LegendaryItems;

/**
 * Created by xiyuanbupt on 4/1/17.
 */
public class Try {

    /**
     * @param P 给定的可能性
     * @param Q 如果没有获得, 失败的可能性
     * @param N
     * @param base
     * @return
     */
    double getItems(int P, double Q, int N, int base){
        if(N==0)return 0;
        //
        double curr = base < 7 ? P / Math.pow(2, base) * 0.01:0;
        double pre  = 1.0, i = 1.0, result = 0;
        while (curr<1.0){
            result += pre * curr * i;
            pre *= 1 - curr;
            curr += Q;
            i++;
        }
        return 1.0;
    }

    public static void main(String[] args){
        Try mytry = new Try();
    }
}
