package main.java.bupt.wxy.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/26/17.
 524. Longest Word in Dictionary through Deleting My SubmissionsBack To Contest
 User Accepted: 609
 User Tried: 827
 Total Accepted: 619
 Total Submissions: 2039
 Difficulty: Medium
 Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 Example 1:
 Input:
 s = "abpcplea", d = ["ale","apple","monkey","plea"]

 Output:
 "apple"
 Example 2:
 Input:
 s = "abpcplea", d = ["a","b","c"]

 Output:
 "a"
 Note:
 All the strings in the input will only contain lower-case letters.
 The size of the dictionary won't exceed 1,000.
 The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1=o1.length();
                int len2=o2.length();
                if(len1!=len2)return len2-len1;
                return o1.compareTo(o2);
            }
        });
        for(String pattern:d){
            if(match(s,pattern))return pattern;
        }
        return "";

    }

    private boolean match(String s, String pattern){
        char[] s_c=s.toCharArray();
        char[] p_c=pattern.toCharArray();

        int len_s=s_c.length;
        int len_p=p_c.length;

        int i=0;
        int j=0;
        while (i<len_s&&j<len_p){
            if(s_c[i]==p_c[j]){
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        return j==len_p;
    }

    public static void main(String[] args){
        LongestWordInDictionaryThroughDeleting l=new LongestWordInDictionaryThroughDeleting();
        System.out.println(l.match("abpcplea","apple"));
    }
}
