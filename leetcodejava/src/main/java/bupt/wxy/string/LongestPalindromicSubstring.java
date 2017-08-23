package bupt.wxy.string;

/**
 * Created by xiyuanbupt on 1/11/17.
 5. Longest Palindromic Substring
 Difficulty: Medium
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.length()==0)return s;

        char[] str=s.toCharArray();
        int max=0;
        // 寻找偶数的回文
        int start=0;
        int end=0;
        for(int i=0;i<str.length-1;i++){
            int len=0;
            while (i-len>=0&&i+1+len<str.length&&str[i-len]==str[i+1+len])len++;
            if(2*len>max){
                start=i-len+1;
                end=i+len;
                max=2*len;
            }
        }

        // 寻找奇数的回文
        for(int i=0;i<str.length-1;i++){
            int len=0;
            while (i-len>0&&i+1+len<str.length&&str[i-len-1]==str[i+1+len])len++;
            if(2*len+1>max){
                start=i-len;
                end=i+len;
                max=2*len+1;
            }
        }
        return s.substring(start,end+1);
    }
}
