package main.java.bupt.wxy.array.easy;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 1/13/17.
 88. Merge Sorted Array   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 138733
 Total Submissions: 441813
 Difficulty: Easy
 Contributors: Admin
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Solution_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp= Arrays.copyOf(nums1,m);
        int k=0;
        int i=0,j=0;
        while (i<m&&j<n){
            if(tmp[i]<nums2[j]){
                nums1[k++]=tmp[i++];
            }
            else {
                nums1[k++]=nums2[j++];
            }
        }
        while (i<m){
            nums1[k++]=tmp[i++];
        }
        while (j<n)nums1[k++]=nums2[j++];

    }
}
