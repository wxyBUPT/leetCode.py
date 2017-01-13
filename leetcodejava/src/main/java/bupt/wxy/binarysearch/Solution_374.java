package main.java.bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 1/13/17.
 374. Guess Number Higher or Lower   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 34707
 Total Submissions: 103367
 Difficulty: Easy
 Contributors: Admin
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example:
 n = 10, I pick 6.

 Return 6.
 */
public class Solution_374 {

    public int guessNumber(int n) {
        int i=1;
        int j=n;
        while (i<=j){
            int mid=i+(j-i)/2;
            if(guess(mid)==0)return mid;
            if(guess(mid)==-1)j=mid-1;
            else i=mid+1;
        }
        return -1;
    }

    int guess(int n){
        return -1;
    }
}
