package main.java.bupt.wxy.hashtable;


import java.util.Arrays;

/**
 * Created by xiyuanbupt on 1/3/17.
 274. H-Index
 Total Accepted: 59258
 Total Submissions: 185323
 Difficulty: Medium
 Contributors: Admin
 Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 */
public class H_Index {

    // 56.07%
    public int hIndex(int[] citations) {
        int len=citations.length;
        if(len==0)return 0;
        int[] hash=new int[len+1];
        for(int citation:citations){
            if(citation>len){
                hash[len]+=1;
            }
            else hash[citation]+=1;
        }
        int t=0;
        for(int i=len;i>=0;i--){
            t+=hash[i];
            if(t>=i)return i;
        }
        return 0;
    }
}
