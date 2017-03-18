package main.java.bupt.wxy.hashtable.easy;

/**
 * Created by xiyuanbupt on 3/11/17.
 387. First Unique Character in a String
 Difficulty: Easy
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {

    // 97.16%
    public int firstUniqChar(String s) {

        int[] map=new int[26];
        for(char c:s.toCharArray()){
            map[c-'a']++;
        }
        int i=0;
        for(char c:s.toCharArray()){
            if(map[c-'a']==1)return i;
            i++;
        }
        return -1;
    }
}
