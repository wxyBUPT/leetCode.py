package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 2/14/17.
 312. Burst Balloons
 Description  Submission  Solutions  Add to List
 Total Accepted: 22196
 Total Submissions: 53004
 Difficulty: Hard
 Contributors: Admin
 Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 Example:

 Given [3, 1, 5, 8]

 Return 167

 nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 */
public class BurstBalloons {

    public int maxCoinsWro(int[] nums){
        if(nums.length<1)return 0;
        int[][] dp=new int[nums.length][nums.length];

        for(int i=nums.length-1;i>=0;i--){
            for(int j=i;j<nums.length;j++){
                for(int k=i;k<=j;k++){
                    dp[i][j]=Math.max(dp[i][j],
                            (i==0?1:nums[i-1])*nums[k]*(j+1==nums.length?1:nums[j+1])+
                                    (k==0?0:dp[i][k-1])+(k+1==nums.length?0:dp[k+1][j])
                    );
                }
            }
        }
        return dp[0][nums.length-1];
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                    coins += i != start ? dp[start][i - 1] : 0;
                    coins += i != end ? dp[i + 1][end] : 0;
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    private int getValue(int[] nums, int i) {
        if (i < 0 || i >= nums.length) {
            return 1;
        }
        return nums[i];
    }

    /**
     * 下面代码用于不合并的情况
    public int maxCoinsWrong(int[] nums) {
        if(nums.length<1)return 0;
        int[][] dp=new int[nums.length][nums.length];

        for(int i=nums.length-1;i>=0;i--){
            dp[i][i]=nums[i];
            for(int j=i+1;j<nums.length;j++){
                dp[i][j]=Math.max(
                        nums[i]*nums[i+1]+dp[i+1][j],
                        nums[j]*nums[j-1]+dp[i][j-1]
                );
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],nums[k-1]*nums[k]*nums[k+1]+dp[i][k-1]+dp[k+1][j]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
     **/

    public static void main(String[] args){
        BurstBalloons burstBalloons=new BurstBalloons();
        int[] nums={3,8};
        System.out.println(burstBalloons.maxCoins(nums));
    }
}
