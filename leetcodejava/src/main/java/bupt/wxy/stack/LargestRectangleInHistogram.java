package bupt.wxy.stack;

/**
 * Created by xiyuanbupt on 1/16/17.
 84. Largest Rectangle in Histogram
 Difficulty: Hard
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 find the area of largest rectangle in the histogram.

 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.

 Subscribe to see which companies asked this question
 */

import java.util.Stack;

/**
 * 求最大面积
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        Stack<Integer> s=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=len;i++){
            int h=(i==len?0:heights[i]);
            if(s.isEmpty()||h>=heights[s.peek()]){
                s.push(i);
            }
            else {
                int tp=s.pop();
                maxArea=Math.max(maxArea,heights[tp]*(s.isEmpty()?i:i-1-s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
