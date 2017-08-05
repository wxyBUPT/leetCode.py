package bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 3/2/17.
 424. Longest Repeating Character Replacement
 Difficulty: Medium

 Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times.
 Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

 Note:
 Both the string's length and k will not exceed 104.

 Example 1:

 Input:
 s = "ABAB", k = 2

 Output:
 4

 Explanation:
 Replace the two 'A's with two 'B's or vice versa.
 Example 2:

 Input:
 s = "AABABBA", k = 1

 Output:
 4

 Explanation:
 Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeationCharacterReplacement {

    // 可以使用 26 * O(n) 的算法来解决, 但是利用空间换时间来记录每个字母出现的次数可以减小时间复杂度
    // 然后各种利用变量保存之前的状态
    // 下面的解法找到了很多的条件
    // 62.80%
    public int characterReplacement(String s, int k) {
        char[] chars=s.toCharArray();
        int[] map=new int[26];
        int start=0;
        int max_char_count=0;
        for(int i=0, len=chars.length;i<len;i++){
            map[chars[i]-'A']++;
            max_char_count=Math.max(max_char_count,map[chars[i]-'A']);
            if(max_char_count+k<=i-start){
                map[chars[start++]-'A']--;
            }
        }
        return s.length()-start;
    }
}
