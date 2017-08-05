package bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 2/26/17.
 523. Continuous Subarray Sum

 Difficulty: Medium
 Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

 Example 1:
 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 Example 2:
 Input: [23, 2, 6, 4, 7],  k=6
 Output: True
 Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 Note:
 The length of the array won't exceed 10,000.
 You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */

/**
 * 注意 continuous subarray
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        k=Math.abs(k);

        for(int i=0;i<nums.length-1;i++){
            int sum=nums[i];
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];


                int n=0;
                if(k==0){
                    if(sum==0)return true;
                    else continue;
                }
                while (n*k<=sum){
                    if(n*k==sum)return true;
                    n++;
                }
            }
        }
        return false;
    }

    // Memory Limit Exceeded
    public boolean checkSubarraySumOOM(int[] nums, int k) {
        k=Math.abs(k);

        int[][] dp=new int[nums.length][nums.length];
        for(int i=nums.length-1;i>=0;i--){
            dp[i][i]=nums[i];

            for(int j=i+1;j<nums.length;j++){
                dp[i][j]=nums[j]+dp[i][j-1];

                int n=0;
                if(k==0){
                    if(dp[i][j]==0)return true;
                    else continue;
                }
                while (n*k<=dp[i][j]){
                    if(n*k==dp[i][j])return true;
                    n++;
                }
            }
        }
        return false;
    }


    // 题目意思没有看懂, 想复杂了.....
    // 下面方法适合
    public boolean checkSubarraySumWrone(int[] nums, int k) {
        k=Math.abs(k);
        int sum=0;

        for(int num:nums){
            sum+=num;
        }

        int pre=0;
        for(int i=0;i<nums.length-1;i++){

            if(checkSubarraySumWithStart(nums,i,k,sum-pre))return true;
            pre+=nums[i];
        }
        return false;

    }

    private boolean checkSubarraySumWithStart(int[] nums, int start, int k, int sum){

        k=Math.abs(k);

        int[] dp=new int[sum+1];
        for(int i=start;i<nums.length;i++){
            int num=nums[i];
            if(num==0)dp[num]++;
            else if(dp[num]==0)dp[num]=1;
            for(int j=num+1;j<sum+1;j++){
                if(dp[j-num]>0)
                    dp[j]=dp[j-num]+1;
            }

            // 每一个子数组判断是否有符合条件的值
            if(k==0){
                if(dp[0]>1)return true;
                else {
                    continue;
                }
            }
            int n=1;
            while (n*k<=sum){
                if(dp[n*k]>1)return true;
                n++;
            }
        }
        return false;
    }
}
