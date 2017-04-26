package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 3/24/17.
 263. Ugly Number
 Difficulty: Easy
 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {

    // 24.73%
    public boolean isUgly(int num) {
        if(num < 1) return false;
        int[] nums = {2, 3, 5};
        while (num!=1){
            boolean divided = false;
            for(int i:nums){
                if(num%i==0){
                    divided = true;
                    num = num / i;
                }
            }
            if(!divided)return false;
        }
        return true;
    }
}
