package main.java.bupt.wxy.array;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 2/27/17.
 66. Plus One Add to List
 Description  Submission  Solutions
 Total Accepted: 152178
 Total Submissions: 407247
 Difficulty: Easy
 Contributors: Admin
 Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

    // 8.46%
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while (i>=0){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
            i--;
        }

        int[] res=new int[digits.length+1];
        res[0]=1;
        System.arraycopy(digits,0,res,1,res.length-1);
        return res;
    }
}
