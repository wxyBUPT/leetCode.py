package main.java.bupt.wxy.mergesort;

/**
 * Created by xiyuanbupt on 1/13/17.
 315. Count of Smaller Numbers After Self   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 25112
 Total Submissions: 74921
 Difficulty: Hard
 Contributors: Admin
 You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].
 */
public class Solution_315 {


    class Tuple{
        public int val;
        public int idx;

        public Tuple(int val, int idx){

            this.val=val;
            this.idx=idx;
        }
    }
}
