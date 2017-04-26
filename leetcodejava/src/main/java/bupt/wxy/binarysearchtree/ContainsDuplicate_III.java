package main.java.bupt.wxy.binarysearchtree;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by xiyuanbupt on 1/11/17.
 220. Contains Duplicate III
 Difficulty: Medium

 Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */

/**
 * 首先本题目正常的想法是遍历数组, 对每一个值的后面k个元素与前面的值比较, 看是否满足条件
 * 最坏的时间复杂度是 O n*k*k
 * 避免不必要的比较之后时间复杂度可以提升为 O n*k
 * 使用平衡二叉树之后,时间复杂度可以提升为 O n* log(k)
 */
public class ContainsDuplicate_III {

    // %32.41%
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1||t<0)return false;
        SortedSet<Long> set=new TreeSet<>();
        for(int i=0;i<k&&i<nums.length;i++){

            if(set.subSet((long)nums[i]-t,(long)nums[i]+t+1).size()!=0)return true;
            set.add((long)nums[i]);
        }
        for(int i=k;i<nums.length;i++){

            if(set.subSet((long)nums[i]-t,(long)nums[i]+t+1).size()!=0)return true;
            set.add((long)nums[i]);
            set.remove((long)nums[i-k]);
        }
        return false;
    }

    // 还可以使用桶排序, 思想差不多, 下面是lx223 的代码
    public boolean containsNearbyAlmostDuplicatebucket(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

}
