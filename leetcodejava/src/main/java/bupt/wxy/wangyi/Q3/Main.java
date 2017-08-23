package bupt.wxy.wangyi.Q3;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 8/12/17.
 */
public class Main {

    static int n, k;

    static int res = 0;

    static int i_res = 0;
    static int i_max = 0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        for(int i = 1; i<=k; ){
            i_res = 0;
            i_max = i;
            backtracking(i, 1);
            i_res *= (k - i_max);
            res += i_res;
            i += (k - i_max);
        }
        System.out.println(res);
    }

    static void backtracking(int pre, int curr_pos){
        if(curr_pos == n){
            i_res ++;
            return;
        }
        for(int i = 1; i<=k ;i++){
            if(i >= pre || pre % i != 0){ // 满足条件
                i_max = Math.max(i_max, i);
                backtracking(i, curr_pos +1);
            }
        }
    }
}
