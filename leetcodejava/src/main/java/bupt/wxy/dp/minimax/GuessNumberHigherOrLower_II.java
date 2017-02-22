package main.java.bupt.wxy.dp.minimax;

/**
 * Created by xiyuanbupt on 1/4/17.
 375. Guess Number Higher or Lower II
 Difficulty: Medium

 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

 Example:

 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.
 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

 Hint:

 The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
 Take a small example (n = 3). What do you end up paying in the worst case?
 Check out this article if you're still stuck.
 The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
 As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?
 Credits:
 Special thanks to @agave and @StefanPochmann for adding this problem and creating all test cases.


 */
public class GuessNumberHigherOrLower_II {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        return dfs(1, n, dp);
    }

    int dfs(int start, int end, int[][] dp){
        if(start>=end)return 0;
        if(dp[start][end]>0){
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            // 条件限定,只能做最坏的打算
            int tmp = i+Math.max(dfs(start,i-1,dp), dfs(i+1,end,dp));
            // 但是选择哪个点自己是可以定的
            res=Math.min(res,tmp);
        }
        dp[start][end]=res;
        return res;
    }
}
class Solution{
    public int getMoneyAmount(int n){
        int[][] dp=new int[n+1][n+1];
        for(int j=2;j<=n;j++)
            for(int i=j-1;i>0;i--){
                int globalMin=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int localMax = k+Math.max(dp[i][k-1],dp[k+1][j]);
                    globalMin=Math.min(localMax,globalMin);
                }
                dp[i][j]=i+1==j?i:globalMin;
            }
        return dp[1][n];

    }
}
