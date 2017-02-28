package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 2/28/17.
 169. Majority Element   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 160314
 Total Submissions: 360337
 Difficulty: Easy
 Contributors: Admin
 Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int major=nums[0];
        int count=1;
        for(int i=1,len=nums.length;i<len;i++){
            int num=nums[i];
            if(num==major)count++;
            else if(count==0){
                major=num;
                count=1;
            }else {
                count--;
            }
        }
        return major;
    }
}
