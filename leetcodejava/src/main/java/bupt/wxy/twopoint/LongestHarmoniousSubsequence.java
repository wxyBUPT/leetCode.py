package bupt.wxy.twopoint;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 7/31/17.
 594. Longest Harmonious Subsequence
 DescriptionHintsSubmissionsDiscussSolution
 Discuss Pick One
 We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        int len = nums.length;
        if(len <= 1)return len;
        int start = 0, end = 0;
        int max = nums[0], min = nums[0];
        Map<Integer, Integer> counter = new HashMap<>();
        return 0;
    }
}
