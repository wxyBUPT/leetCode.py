package main.java.bupt.wxy.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 1/7/17.
 128. Longest Consecutive Sequence   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 89106
 Total Submissions: 252581
 Difficulty: Hard
 Contributors: Admin
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
// 在这里体会一下unionfind, 这里是借助于hashmap实现并查集, 并且一般要求在On 时间复杂度解决问题要考虑使用hashmap
public class Solution_128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int res=Integer.MIN_VALUE;
        for(int n:nums){
            if(!map.containsKey(n)) {
                int leftlen = map.getOrDefault(n - 1, 0);
                int rightlen = map.getOrDefault(n + 1, 0);
                int sum = leftlen + 1 + rightlen;
                map.put(n, sum);

                // 需要更新此批的联通节点,因为中间的节点不会有相邻的节点了,所以不用更新
                map.put(n - leftlen, sum);
                map.put(n + rightlen, sum);
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
