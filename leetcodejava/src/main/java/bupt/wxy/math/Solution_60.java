package main.java.bupt.wxy.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/11/17.
 60. Permutation Sequence   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 72511
 Total Submissions: 267588
 Difficulty: Medium
 Contributors: Admin
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.
 */

// 65.51%
public class Solution_60 {

    static int[] dp=new int[10];
    static {
        dp[1]=1;
        for(int i=2;i<10;i++){
            dp[i]=dp[i-1]*i;
        }
    }

    public String getPermutation(int n, int k) {

        StringBuilder sb=new StringBuilder();
        List<Integer> nums=new LinkedList<>();
        for(int i=0;i<n;i++)nums.add(i+1);

        // 开始选n个数
        while (n>1){
            int div_res=k/dp[n-1];
            int div_rem=k%dp[n-1];
            if(div_rem==0){
                sb.append(nums.remove(div_res-1));
                k=dp[n-1];
            }
            else {
                sb.append(nums.remove(div_res));
                k=div_rem;
            }
            n--;

        }
        // 就剩下一个数了当然要选上
        sb.append(nums.remove(0));
        return sb.toString();
    }
}
