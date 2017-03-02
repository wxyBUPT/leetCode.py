package main.java.bupt.wxy.bitmanipulation;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 3/2/17.
 318. Maximum Product of Word Lengths Add to List
 Description  Submission  Solutions
 Total Accepted: 44249
 Total Submissions: 103390
 Difficulty: Medium
 Contributors: Admin
 Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.


 */
public class MaximumProductOfWordLenghts {

    // 每个string 可以hash成一个int, 每两个int之间做位与操作等于零既满足条件
    // 67.96%
    public int maxProduct(String[] words) {

        int[] hash_map=new int[words.length];
        int[] len_map=new int[words.length];
        for(int i=0,len=words.length;i<len;i++){
            int hash=0;
            for(char c:words[i].toCharArray()){
                hash|=1<<(c-'a');
            }
            hash_map[i]=hash;
            len_map[i]=words[i].length();
        }

        int res=0;
        for(int i=0,len=words.length;i<len;i++){
            for(int j=i+1;j<len;j++){
                if((hash_map[i]&hash_map[j])==0){
                    res=Math.max(len_map[i]*len_map[j],res);
                }
            }
        }
        return res;

    }
}
