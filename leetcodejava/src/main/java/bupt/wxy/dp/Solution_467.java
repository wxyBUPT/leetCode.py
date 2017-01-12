package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 1/12/17.
 467. Unique Substrings in Wraparound String   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 2866
 Total Submissions: 9462
 Difficulty: Medium
 Contributors: ramanjot
 Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

 Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

 Note: p consists of only lowercase English letters and the size of p might be over 10000.

 Example 1:
 Input: "a"
 Output: 1

 Explanation: Only the substring "a" of string "a" is in the string s.
 Example 2:
 Input: "cac"
 Output: 2
 Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 Example 3:
 Input: "zab"
 Output: 6
 Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
public class Solution_467 {


    // 子字符串之间有一个相互包含的关系
    // 子字符串的个数又能通过dp来求
    public int findSubstringInWraproundString(String p){
        int[] count=new int[26];

        int maxLengthCur=0;
        for(int i=0;i<p.length();i++){
            if(i>0&&((p.charAt(i)-p.charAt(i-1))==1||(p.charAt(i-1)-p.charAt(i))==25)){
                maxLengthCur++;
            }
            else maxLengthCur=1;

            int index=p.charAt(i)-'a';
            count[index]=Math.max(count[index],maxLengthCur);
        }
        int sum=0;
        for(int n:count)sum+=n;
        return sum;
    }

    /**
     * 下面自己想的方法完全是错误的,完全没有想到有重复的情况
    public int findSubstringInWraproundString(String p) {
        int len=p.length();
        if(len==0)return 0;
        char[] strs=p.toCharArray();
        int[][] dp=new int[len][len];
        for(int i=0;i<len;i++)dp[i][i]=1;
        // 计算长度为i的dp
        for(int dist=1;dist<len;dist++){
            for(int i=0;i<len-dist+1;i++){
                dp[i][i+dist]=dp[i][i+dist-1]+dp[i+1][i+dist]+(isSub(strs,i,i+dist)?1:0);
            }
        }
        return dp[0][len-1];
    }

    // 用于判断到j 的子字符串是否是连续的字符串
    boolean isSub(char[] strs, int i, int j){
        for(int k=i+1;k<=j;k++){
            if(strs[k]!='a'){
                if(strs[k-1]!=strs[k]-1)return false;
            }
            else {
                if(strs[k-1]!='z')return false;
            }
        }
        return true;
    }
     **/
}
