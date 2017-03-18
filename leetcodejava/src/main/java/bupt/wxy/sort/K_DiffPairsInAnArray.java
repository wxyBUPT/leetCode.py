package main.java.bupt.wxy.sort;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 3/5/17.
 532. K-diff Pairs in an Array
 Difficulty: Easy

 Example 1:
 Input: [3, 1, 4, 1, 5], k = 2
 Output: 2
 Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 Although we have two 1s in the input, we should only return the number of unique pairs.
 Example 2:
 Input:[1, 2, 3, 4, 5], k = 1
 Output: 4
 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 Example 3:
 Input: [1, 3, 1, 5, 4], k = 0
 Output: 1
 Explanation: There is one 0-diff pair in the array, (1, 1).
 Note:
 The pairs (i, j) and (j, i) count as the same pair.
 The length of the array won't exceed 10,000.
 All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class K_DiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        for(int i=0,len=nums.length;i<len;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            int tmp=nums[i]+k;
            for(int j=i+1;j<len;j++){
                if(nums[j]==tmp){
                    if(j==i+1||nums[j]!=nums[j-1])res++;
                }
            }
        }
        return res;
    }
}
