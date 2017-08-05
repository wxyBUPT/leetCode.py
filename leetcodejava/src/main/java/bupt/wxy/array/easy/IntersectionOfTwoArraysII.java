package bupt.wxy.array.easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 2/28/17.
 350. Intersection of Two Arrays II
 Difficulty: Easy
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {

    // 75.55%
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res=new LinkedList<>();
        int i=0,j=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }else {
                if(nums1[i]>nums2[j])j++;
                else i++;
            }
        }
        int[] inter=new int[res.size()];
        int k=0;
        for(Iterator<Integer> iterator=res.iterator();iterator.hasNext();){
            inter[k++]=iterator.next();
        }
        return inter;
    }
}
