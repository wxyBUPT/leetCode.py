package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 5/14/17.
 587. Erect the Fence My SubmissionsBack To Contest
 User Accepted: 75
 User Tried: 171
 Total Accepted: 79
 Total Submissions: 372
 Difficulty: Hard
 There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.

 Example 1:
 Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 Explanation:

 Example 2:
 Input: [[1,2],[2,2],[4,2]]
 Output: [[1,2],[2,2],[4,2]]
 Explanation:

 Even you only have trees in a line, you need to use rope to enclose them.
 Note:

 All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
 All input integers will range from 0 to 100.
 The garden has at least one tree.
 All coordinates are distinct.
 Input points have NO order. No order required for output.

 */

/**
 * 两点组合划线, 所有点都在一端则为结果
 */
public class ErectTheFence {


    /**
     * 判断 c 是否在 a b 组成的直线的上面
     * @param a
     * @param b
     * @param c
     * @return
     */
    public boolean underLine(Point a, Point b, Point c){
        return true;
    }
}
