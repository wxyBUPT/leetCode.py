package bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 5/14/17.
 Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 where in each step you can delete one character in either string.

 Example 1:
 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 Note:
 The length of given words won't exceed 500.
 Characters in given words can only be lower-case letters.
 */

/**
 * 很显然是超时的
 * 应该有dp的方法
 */
public class DeleteOperationForTwoStrings {

    char[] chars1;
    char[] chars2;
    int sum_len;
    int min;

    public int minDistance(String word1, String word2) {
        if(word1.length()>word2.length()){
            String tmp = word1;
            word1 = word2;
            word2 = tmp;
        }
        chars1 = word1.toCharArray();
        chars2 = word2.toCharArray();
        min = chars1.length + chars2.length;
        sum_len = min;
        backtracking(0, new ArrayList<>(chars1.length));
        return  min;
    }

    public void backtracking(int i, List<Character> chosed){
        boolean match = true;
        int j = 0;
        for(char c:chosed){
            // find first match or over length
            while (j<chars2.length && chars2[j]!=c)j++;
            if(j==chars2.length){
                match = false;
                break;
            }
            j++;
        }
        if(match){
            min = Math.min(min, sum_len - 2 * chosed.size());
        }
        if(i==chars1.length)return;
        // chose chars1[i]
        chosed.add(chars1[i]);
        backtracking(i+1, chosed);
        chosed.remove(chosed.size()-1);
        // don't chose chars1[i]
        backtracking(i+1, chosed);
    }

}
