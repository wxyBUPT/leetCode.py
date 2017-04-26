package main.java.bupt.wxy.acm.SquareCoins;


import java.util.*;

/**
 * 使用backtracking超时,所以本题应该向dp方向靠
 * 同时利用了相同个数组成特定和所需要的组合不变这一性质, 或者概率很小
 */
public class Main {

    int COINS_SIZE = 18;
    int MAX_AMOUNT = 2001;
    List<Set<Integer>> dp = new ArrayList<>(MAX_AMOUNT);
    int[] coins = new int[COINS_SIZE];
    public Main(){
        for(int i=1;i<COINS_SIZE;i++){
            coins[i] = i * i;
        }
    }

    void calculateDp(){
        for(int i=0; i<MAX_AMOUNT;i++){
            dp.add(new HashSet<>());
        }
        dp.get(0).add(0);
        for(int i=1;i<MAX_AMOUNT;i++){
            for(int coin:coins){
                if(i-coin>=0){
                    Set<Integer> th_level = dp.get(i);
                    for(Integer co : dp.get(i-coin)){
                        th_level.add(co+1);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        main.calculateDp();
        int T = in.nextInt();
        while (T>0){
            T--;
            System.out.println(main.dp.get(in.nextInt()).size());
        }
    }

    /**
     * 下面使用回溯法会产生异常, 所以考虑使用dp
    long res = 0;

    void backtracking(int curr, int index, int total){
        if(curr == total)this.res ++;
        for(int i = index; i<COINS_SIZE; i++){
            if(curr + coins[i]>total)return;
            backtracking(curr + coins[i], i, total);
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T>0){
            T--;
            main.res = 0;
            main.backtracking(0, 1, in.nextInt());
            System.out.println(main.res );
        }
    }
     **/
}
