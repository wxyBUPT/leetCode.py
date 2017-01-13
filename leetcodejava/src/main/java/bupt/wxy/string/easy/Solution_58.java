package main.java.bupt.wxy.string.easy;

/**
 * Created by xiyuanbupt on 1/13/17.
 58. Length of Last Word   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 125518
 Total Submissions: 403623
 Difficulty: Easy
 Contributors: Admin
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */

/**
 * 下巴都吓掉了,这么简单......
 */
public class Solution_58 {

    public int lengthOfLastWord(String s) {
        int len=s.length();
        int res=0;
        int j=len-1;
        while (j>=0&&s.charAt(j)==' ')j--;
        while (j>=0&&s.charAt(j)!=' '){
            res++;
            j--;
        }
        return res;
    }
}
