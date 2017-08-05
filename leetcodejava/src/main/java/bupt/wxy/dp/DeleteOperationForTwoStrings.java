package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 5/14/17.
 * 583. Delete Operation for Two Strings My SubmissionsBack To Contest
 User Accepted: 466
 User Tried: 627
 Total Accepted: 470
 Total Submissions: 1208
 Difficulty: Medium
 Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

 Example 1:
 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 Note:
 The length of given words won't exceed 500.
 Characters in given words can only be lower-case letters.
 */


import java.util.Arrays;

/**
 * dp 求最长公共子串
 *
 */
public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int len1 = chars1.length, len2 = chars2.length;
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i<len1 +1; i++){
            for(int j = 1; j<len2 + 1; j++){
                if(chars1[i-1]==chars2[j-1])dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }
}
