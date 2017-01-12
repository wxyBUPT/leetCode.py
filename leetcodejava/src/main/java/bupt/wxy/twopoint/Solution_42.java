package main.java.bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 1/12/17.
 42. Trapping Rain Water   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 95561
 Total Submissions: 270638
 Difficulty: Hard
 Contributors: Admin
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Subscribe to see which companies asked this question

 Hide Tags Array Stack Two Pointers
 Show Similar Problems

 */

/**
 * 从两端开始向中间遍历
 * 本题目还有使用stack解决的版本, 在stack目录下, 个人觉得使用stack比较难想
 */
public class Solution_42 {

    // 44.90% bugfree !!!!!
    // 只使用一个curr_height 可能很难想也很难理解
    // 可以想: 记录左边最高的值,记录右边最高的值, curr_height 为最小值(装水)
    public int trap(int[] height) {
        if(height.length<3)return 0;
        int i=0,j=height.length-1;
        int curr_height=Math.min(height[i],height[j]);
        int res=0;
        while (i<j){

            if(height[i]>=height[j]){
                res+=(curr_height-height[j--]);
                if(height[j]>curr_height)curr_height=Math.min(height[i],height[j]);
            }else {
                res+=(curr_height-height[i++]);
                if(height[i]>curr_height)curr_height=Math.min(height[i],height[j]);
            }
        }
        return res;

    }
}
