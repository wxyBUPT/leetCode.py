package main.java.bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 1/3/17.
 367. Valid Perfect Square
 Total Accepted: 26215
 Total Submissions: 70223
 Difficulty: Medium
 Contributors: Admin
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long i=1,j=num/2+1;
        while (i<=j){
            long mid=i+(j-i)/2;
            long tmp=mid*mid;
            if(tmp==num)return true;
            if(tmp>num)j=mid-1;
            else i=mid+1;
        }
        return false;
    }
}
