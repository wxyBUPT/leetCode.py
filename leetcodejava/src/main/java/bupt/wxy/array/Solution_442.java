package main.java.bupt.wxy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 12/31/16.
 442. Find All Duplicates in an Array   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 8689
 Total Submissions: 18556
 Difficulty: Medium
 Contributors: shen5630
 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 */
public class Solution_442 {

    // 77.04%
    // 二元状态都可以考虑使用index来存储
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num:nums){
            int index = Math.abs(num)-1;
            if(nums[index]<0){
                res.add(Math.abs(num));
                continue;
            }
            nums[index]=-nums[index];
        }
        return res;
    }
}
