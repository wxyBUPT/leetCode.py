package bupt.wxy.trie;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 3/2/17.
 421. Maximum XOR of Two Numbers in an Array
 Difficulty: Medium

 Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

 Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

 Could you do this in O(n) runtime?

 Example:

 Input: [3, 10, 5, 25, 2, 8]

 Output: 28

 Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class MaximumXOROfTwoNumbersInAnArray {
    // 思想是字典树的思想,但是使用set代替字典树
    // 有很多题目的思想并不是从前向后推, 而是从后向前推
    public int findMaximumXOR(int[] nums) {
        int max=0,mask=0;
        for(int i=31;i>=0;i--){
            mask=mask|(1<<i);
            Set<Integer> set=new HashSet<>();
            for(int num:nums){
                set.add(num&mask);
            }
            int tmp=max|(1<<i);
            for(int prefix:set){
                if(set.contains(tmp^prefix)){
                    max=tmp;
                    break;
                }
            }
        }
        return max;
    }
}
