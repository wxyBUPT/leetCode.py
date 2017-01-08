package main.java.bupt.wxy.hashtable;

import com.sun.deploy.config.MacOSXPlatform;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/8/17.
 49. Group Anagrams   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 109481
 Total Submissions: 344533
 Difficulty: Medium
 Contributors: Admin
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"
 */
public class Solution_49 {

    // 下面思想对,但是对数组的操作还有另外的方法
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new LinkedList<>();
        Map<String, List<String>> map=new HashMap<>(strs.length);

        for(String str:strs){
            int[] key=new int[26];
            for(Character c:str.toCharArray()){
                key[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i:key){
                sb.append(i);
            }
            String s_key=sb.toString();
            if(!map.containsKey(s_key)){
                map.put(s_key,new LinkedList<>());
            }
            map.get(s_key).add(str);
        }

        for(List<String> value:map.values()){
            res.add(value);
        }
        return res;
    }
}
