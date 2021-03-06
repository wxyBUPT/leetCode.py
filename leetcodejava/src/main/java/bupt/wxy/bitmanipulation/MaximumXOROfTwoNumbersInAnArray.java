package bupt.wxy.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 3/10/17.
 421. Maximum XOR of Two Numbers in an Array
 Difficulty: Medium
 Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231(注:二的三十一次幂).

 Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

 Could you do this in O(n) runtime?

 Example:

 Input: [3, 10, 5, 25, 2, 8]

 Output: 28

 Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class MaximumXOROfTwoNumbersInAnArray {

    public int findMaximumXOR(int[] nums) {

        int mask=0;
        int max=0;
        for(int i=30;i>=0;i--){
            mask=mask|1<<i;
            Set<Integer> set=new HashSet<>();
            for(int num:nums){
                set.add(mask&num);
            }
            int tmp=max|1<<i;
            for(int prefix:set){
                if(set.contains(prefix^tmp)){
                    max=tmp;
                    break;
                }
            }
        }
        return max;
    }
}
