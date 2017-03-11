package main.java.bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 2/2/17.
 28. Implement strStr()
 Difficulty: Easy
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Implement_strStr {

    /**
     * find subString
     * 51.91%
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int i=0,j;
        while (i<=haystack.length()-needle.length()){
            int k=i;
            j=0;
            while (j<needle.length()&&haystack.charAt(k++)==needle.charAt(j)){
                j++;
            }
            if(j==needle.length())return i;
            i++;
        }
        return -1;
    }
}
