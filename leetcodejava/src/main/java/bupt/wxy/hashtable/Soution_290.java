package main.java.bupt.wxy.hashtable;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/13/17.
 290. Word Pattern   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 63451
 Total Submissions: 197923
 Difficulty: Easy
 Contributors: Admin
 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 */
public class Soution_290 {

    public boolean wordPattern(String pattern, String str) {
        String[] strs=str.split(" ");
        char[] chrs =pattern.toCharArray();
        if(chrs.length!=strs.length)return false;
        Map<Character,String> map=new HashMap<>();
        Set<String> seen=new HashSet<>();
        for(int i=0;i<strs.length;i++){
            if(map.containsKey(chrs[i])){
                if(!map.get(chrs[i]).equals(strs[i]))return false;
            }
            else {
                if(seen.contains(strs[i]))return false;
                else {
                    map.put(chrs[i],strs[i]);
                    seen.add(strs[i]);
                }
            }
        }
        return true;
    }

    // 突出一个患难与共
    public boolean stefan(String pattern, String str){
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString("a b c d  e".split(" ")));
    }
}
