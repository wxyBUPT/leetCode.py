package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 1/13/17.
 172. Factorial Trailing Zeroes   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 80921
 Total Submissions: 232100
 Difficulty: Easy
 Contributors: Admin
 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.

 Subscribe to see which companies asked this question

 Hide Tags
 */

/**
 * 因为因子中有5, 则一定会出来一个10
 * 所以找所有的这些数中因子5的个数
 */
public class Solution_172 {

    public int trailingZeroes(int n) {
        int res=0;
        while (n!=0){
            res+=n/5;
            n/=5;
        }
        return res;
    }
}
