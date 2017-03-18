package main.java.bupt.wxy.hashtable.easy;

/**
 * Created by xiyuanbupt on 3/11/17.
 409. Longest Palindrome Add to List
 Difficulty: Easy

 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

    // 96.48%
    public int longestPalindrome(String s) {
        if(s.length()==0)return 0;

        int[] map=new int[128];
        for(char c:s.toCharArray()){
            map[c-'A']++;
        }
        boolean hasSingle=false;
        int res=0;
        for(int i=0;i<128;i++){
            if(map[i]%2==1)hasSingle=true;
            res+=map[i]/2;
        }
        return res*2+(hasSingle?1:0);
    }
}
