package bupt.wxy.heap;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xiyuanbupt on 4/9/17.
 554. Brick Wall My SubmissionsBack To Contest
 User Accepted: 629
 User Tried: 813
 Total Accepted: 639
 Total Submissions: 1953
 Difficulty: Medium
 There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

 The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

 If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

 You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

 Example:
 Input:
 [[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
 Output: 2
 Explanation:

 Note:
 The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 */

/**
 * 优先队列的应用
 * 41ms
 */

public class BrickWall {

    static class WallLine implements Comparable<WallLine>{

        int line_no;
        int curr_bricks;
        int curr_len;

        public WallLine(int line_no, int curr_len){
            this.line_no = line_no;
            this.curr_bricks = 0;
            this.curr_len = curr_len;
        }

        @Override
        public int compareTo(WallLine o) {
            return curr_len - o.curr_len;
        }
    }

    public int leastBricks(List<List<Integer>> wall) {
        int line_count = wall.size();
        if(wall.size()==0)return -1;
        int total_len = 0;
        for(int len:wall.get(0)){
            total_len += len;
        }
        PriorityQueue<WallLine> wallLines = new PriorityQueue<>();
        // init
        int min_cross = line_count;
        for(int i=0;i<line_count;i++){
            wallLines.add(new WallLine(i, wall.get(i).get(0)));
        }
        while (wallLines.peek().curr_len != total_len){
            int curr_min = wallLines.peek().curr_len;
            int cross_line = line_count;
            while (wallLines.peek().curr_len==curr_min){
                cross_line--;
                WallLine wallLine = wallLines.poll();
                wallLine.curr_len += wall.get(wallLine.line_no).get(++wallLine.curr_bricks);
                wallLines.add(wallLine);
            }
            min_cross = Math.min(min_cross, cross_line);
        }
        return min_cross;
    }
}
