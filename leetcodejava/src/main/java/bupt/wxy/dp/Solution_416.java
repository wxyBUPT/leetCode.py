package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 1/3/17.
 416. Partition Equal Subset Sum   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 11030
 Total Submissions: 29494
 Difficulty: Medium
 Contributors: Admin
 Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.
 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.
 */

// 还可以使用dfs但是不能通过oj
    
public class Solution_416 {

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        boolean[] dp=new boolean[sum/2+1];
        dp[0]=true;
        for(int num:nums){
            for(int j=sum/2;j>=num;j--){
                dp[j]=dp[j]||dp[j-num];
            }
        }
        return dp[sum/2];
    }

    public static void main(String[] args){
        boolean[] dp= new boolean[2];
        System.out.println(dp[0]);
    }
}
