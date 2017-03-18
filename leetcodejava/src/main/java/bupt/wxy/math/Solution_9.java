package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 1/3/17.
 9. Palindrome Number   Add to List QuestionEditorial Solution  My Submissions
 Difficulty: Easy
 Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution_9 {

    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int y = 0;
        int tmp = x;
        while (x!=0){
            y=y*10+x%10;
            x/=10;
        }
        return y==tmp;
    }
}
