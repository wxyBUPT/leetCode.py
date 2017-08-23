package bupt.wxy.sort.easy;

/**
 * Created by xiyuanbupt on 3/11/17.
 349. Intersection of Two Arrays
 Difficulty: Easy
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本题有三种方法
 * 1. 使用一个hashset来计算
 * 2. 两个数组排序使用两点来计算
 * 3. 对一个比较好排序的做二分查找
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1= nums1.length;
        int len2=nums2.length;
        int i=0,j=0;
        List<Integer> res=new ArrayList<>();
        while (i<len1&&j<len2){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }else {
                i++;
            }
            // 跳过中间重复的
            while (i!=0&&i!=len1&&nums1[i]==nums1[i-1])i++;
            while (j!=0&&j!=len2&&nums2[j]==nums2[j-1])j++;
        }
        int[] ret=new int[res.size()];
        i=0;
        for(int tmp:res){
            ret[i++]=tmp;
        }
        return ret;
    }
}
