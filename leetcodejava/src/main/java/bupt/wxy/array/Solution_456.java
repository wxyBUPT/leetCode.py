package main.java.bupt.wxy.array;

/**
 * Created by xiyuanbupt on 1/10/17.
 456. 132 Pattern   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 4614
 Total Submissions: 16512
 Difficulty: Medium
 Contributors: love_FDU_llp
 Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

 Note: n will be less than 15,000.

 Example 1:
 Input: [1, 2, 3, 4]

 Output: False

 Explanation: There is no 132 pattern in the sequence.
 Example 2:
 Input: [3, 1, 4, 2]

 Output: True

 Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 Example 3:
 Input: [-1, 3, 2, 0]

 Output: True

 Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 我觉得是一道array题目, 但是tags里面是stack, 先写下array思路
 * 但是明显不是最优的算法
 */
// 2.88% 所以算法不靠谱
public class Solution_456 {

    public boolean find132pattern(int[] nums) {
        if(nums.length<3)return false;
        // 记录最小的值
        int min=nums[0];
        int max=Integer.MIN_VALUE;

        List<Integer> lo=new ArrayList<>();
        List<Integer> hi=new ArrayList<>();

        for(int i=1;i<nums.length;i++){
            for(int j=lo.size()-1;j>=0;j--){
                if(nums[i]<hi.get(j)&&nums[i]>lo.get(j)){
                    return true;
                }
            }
            if(nums[i]<min){
                min=nums[i];
                continue;
            }
            if(nums[i]>min){
                lo.add(min);
                hi.add(nums[i]);
            }
        }
        return false;
    }
}
