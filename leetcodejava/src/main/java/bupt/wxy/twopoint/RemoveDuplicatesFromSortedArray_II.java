package main.java.bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 1/4/17.
 80. Remove Duplicates from Sorted Array II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 100178
 Total Submissions: 287665
 Difficulty: Medium
 Contributors: Admin
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.

 Subscribe to see which companies asked this question
 */
public class RemoveDuplicatesFromSortedArray_II {

    // 这道题做到bugfree好难啊
    public int removeDuplicates(int[] nums) {
        int i=0,j=0;
        while (j<nums.length){
            if(i<2||nums[j]!=nums[i-2]){
                nums[i++]=nums[j];
            }
            j++;
        }
        return i;
    }
}
