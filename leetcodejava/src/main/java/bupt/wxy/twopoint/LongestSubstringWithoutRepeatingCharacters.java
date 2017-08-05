package bupt.wxy.twopoint;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 1/12/17.
 3. Longest Substring Without Repeating Characters
 Difficulty: Medium
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // 39.16%
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,max=0;
        Set<Character> set=new HashSet<>();
        while (j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max=Math.max(max,set.size());
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    // 优化方法,使用数组代替set
    // 95.46%
    public int lenght(String s){
        int i=0,j=0,max=0;
        int[] map=new int[256];
        char[] strs=s.toCharArray();
        while (j<strs.length){
            if(map[strs[j]]==0){
                map[strs[j++]]=1;
                max=Math.max(max,j-i);
            }else {
                map[strs[i++]]--;
            }
        }
        return max;
    }

}
