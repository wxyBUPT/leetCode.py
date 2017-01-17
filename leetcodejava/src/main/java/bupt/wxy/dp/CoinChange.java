package main.java.bupt.wxy.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xiyuanbupt on 1/11/17.
 322. Coin Change
 Total Accepted: 46464
 Total Submissions: 178956
 Difficulty: Medium
 Contributors: Admin
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 */
public class CoinChange {

    // 57.59%
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for(int i=0;i<dp.length;i++)dp[i]=-1;
        dp[0]=0;

        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&dp[i-coins[j]]>-1){
                    if(dp[i]==-1)dp[i]=dp[i-coins[j]]+1;
                    else {
                        if(dp[i-coins[j]]+1<dp[i])dp[i]=dp[i-coins[j]]+1;
                    }
                }
            }
        }
        return dp[amount];

    }
}
