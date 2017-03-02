package main.java.bupt.wxy.bitmanipulation.simple;

/**
 * Created by xiyuanbupt on 3/1/17.
 191. Number of 1 Bits Add to List
 Description  Submission  Solutions
 Total Accepted: 136694
 Total Submissions: 352548
 Difficulty: Easy
 Contributors: Admin
 Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOf1Bits {

    // 利用java32位
    // 13.18%
    public int hammingWeight(int n) {
        int res=0;
        /**
         * 下面代码循环一定会小于32次
        while (n!=0){
            res+=n&1;
            n=n>>>1;
        }
         **/
        for(int i=0;i<32;i++){
            res+=n&1;
            n=n>>>1;
        }
        return res;
    }
}
