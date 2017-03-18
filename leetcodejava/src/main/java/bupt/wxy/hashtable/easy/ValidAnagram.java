package main.java.bupt.wxy.hashtable.easy;

/**
 * Created by xiyuanbupt on 3/11/17.
 242. Valid Anagram
 Difficulty: Easy
 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] map=new int[26];
        for(char c:s.toCharArray()){
            map[c-'a']++;
        }
        for(char c:t.toCharArray()){
            if(map[c-'a']--==0)return false;
        }
        return true;
    }
}
