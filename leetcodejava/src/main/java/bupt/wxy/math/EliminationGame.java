package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 3/2/17.
 390. Elimination Game Add to List
 Description  Submission  Solutions
 Total Accepted: 7968
 Total Submissions: 20206
 Difficulty: Medium
 Contributors: Admin
 There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

 Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

 We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

 Find the last number that remains starting with a list of length n.

 Example:

 Input:
 n = 9,
 1 2 3 4 5 6 7 8 9
 2 4 6 8
 2 6
 6
 Output:
 6
 */
public class EliminationGame {

    // 47.13%
    public int lastRemaining(int n) {
        int remain=n;
        boolean left=true;
        int step=1;
        int head=1;

        while (remain!=1){
            if(left||remain%2==1){
                head=head+step;
            }
            remain=remain/2;
            step*=2;
            left=!left;
        }
        return head;

    }
}
