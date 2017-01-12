package main.java.bupt.wxy.stack;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/12/17.
 42. Trapping Rain Water   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 95563
 Total Submissions: 270643
 Difficulty: Hard
 Contributors: Admin
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Subscribe to see which companies asked this question
 */
public class Solution_42 {

    // 使用栈就是这么一点一点的算
    public int trap(int[] height) {
        if(height.length<3)return 0;
        Stack<Integer> st=new Stack<>();
        int i=0,maxWater=0,maxBotWater=0;
        while (i<height.length){
            if(st.isEmpty()||height[i]<=height[st.peek()]) st.push(i++);
            else {
                int bot=st.pop();
                maxBotWater= st.isEmpty()?0:(Math.min(height[st.peek()],height[i])-height[bot])*(i- st.peek()-1);
                maxWater+=maxBotWater;
            }
        }
        return maxWater;
    }
}
