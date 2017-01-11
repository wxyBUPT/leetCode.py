package main.java.bupt.wxy.bitmanipulation;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/11/17.
 187. Repeated DNA Sequences   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 64584
 Total Submissions: 217949
 Difficulty: Medium
 Contributors: Admin
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */

/**
 * 使用bit 表示hash值
 */

public class Solution_187 {

    // 98.67%
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words=new HashSet<>();
        Set<Integer> doubleWords=new HashSet<>();
        List<String> res=new LinkedList<>();
        // 使用数组代替hashmap 能够节省很多的时间
        char[] map=new char[26];
        map['C'-'A']=1;
        map['G'-'A']=2;
        map['T'-'A']=3;
        for(int i=0;i<s.length()-9;i++){
            int v=0;
            for(int j=i;j<i+10;j++){
                v<<=2;
                v|= map[s.charAt(j)-'A'];
            }
            if(!words.add(v)&&doubleWords.add(v)){
                res.add(s.substring(i,i+10));
            }
        }
        return res;

    }
}
