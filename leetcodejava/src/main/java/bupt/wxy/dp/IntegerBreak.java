package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 3/10/17.
 343. Integer Break Add to List
 Difficulty: Medium
 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {

    public int integerBreak(int n) {

        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                dp[i]=Math.max(Math.max(dp[j],j) * Math.max(i-j,dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }
}
