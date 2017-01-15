package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 1/15/17.
 7. Reverse Integer   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 199016
 Total Submissions: 840457
 Difficulty: Easy
 Contributors: Admin
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321


 */
public class Solution_7 {

    // 59.72%
    public int reverse(int x) {
        int res=0;
        int tmp=Math.abs(x);
        int newRes;
        while (tmp!=0){
            newRes=10*res+tmp%10;
            if((newRes-tmp%10)/10!=res)return 0;
            res=newRes;
            tmp=tmp/10;

        }
        return x<0?-1*res:res;
    }
}
