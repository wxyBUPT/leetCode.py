package main.java.bupt.wxy.divideandconquer;

/**
 * Created by xiyuanbupt on 1/3/17.
 395. Longest Substring with At Least K Repeating Characters   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 8363
 Total Submissions: 23682
 Difficulty: Medium
 Contributors: Admin
 Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class Solution_395 {

    public int longestSubstring(String s, int k) {
        return divideAndConquer(s.toCharArray(), 0, s.length(), k);
    }

    int divideAndConquer(char[] chars, int start, int end, int k){
        if(end-start<k)return 0;
        int[] map=new int[26];
        for(int i=start;i<end;i++){
            map[chars[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            if(map[i]>0&&map[i]<k){
                for(int j=start;j<end;j++){
                    if(chars[j]=='a'+i){
                        int left  =divideAndConquer(chars,start,j,k);
                        int right = divideAndConquer(chars, j+1,end,k);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end-start;
    }
}
