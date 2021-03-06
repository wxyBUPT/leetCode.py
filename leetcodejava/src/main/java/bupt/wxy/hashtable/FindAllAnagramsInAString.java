package main.java.bupt.wxy.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 1/13/17.
 438. Find All Anagrams in a String
 Difficulty: Easy

 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {

    // 85.72%
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new LinkedList<>();
        if(s==null || s.length()==0 || p==null || p.length()==0)return res;
        int[] map = new int[256];
        for(char c:p.toCharArray()){
            map[c]++;
        }
        int left = 0, right = 0, count = p.length();
        int s_len = s.length();
        while (right < s_len){
            if(map[s.charAt(right++)]-->=1)count--;
            if(count==0)res.add(left);
            if(right-left==p.length()&&map[s.charAt(left++)]++>=0)count++;
        }
        return res;
    }

    // 51.26%
    // 2017年3月6日更新, 一下程序比较麻烦, 该题目是一道滑动窗口问题
    // 后续想了想本算法不是最好的, 需要 26*n, 并且使用了两个map
    // 其实可以通过一个map 配合记录p的长度来让代码变得更加简单
    public List<Integer> findAnagramsBad(String s, String p) {
        if(s.length()<p.length())return null;
        int[] s_map=new int[26];
        int[] p_map=new int[26];

        for(char c:p.toCharArray()){
            p_map[c-'a']++;
        }

        char[] s_c=s.toCharArray();
        for(int i=0;i<p.length();i++){
            s_map[s_c[i]-'a']++;
        }
        List<Integer> res=new LinkedList<>();

        for(int i=0;i<s.length()-p.length()+1;i++){
            boolean equal=true;
            for(int j=0;j<26;++j){
                if(s_map[j]!=p_map[j]){
                    equal=false;
                    break;
                }
            }
            if(equal)res.add(i);

            s_map[s_c[i]-'a']--;
            // 显然最后一点会溢出
            if(i+p.length()<s_c.length) {
                s_map[s_c[i + p.length()] - 'a']++;
            }
        }
        return res;
    }
}
