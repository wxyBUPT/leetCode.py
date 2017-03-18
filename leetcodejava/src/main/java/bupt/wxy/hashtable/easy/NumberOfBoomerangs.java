package main.java.bupt.wxy.hashtable.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by xiyuanbupt on 3/11/17.
 447. Number of Boomerangs Add to List
 Difficulty: Easy
 Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

 Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

 Example:
 Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int res=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<points.length;i++){
            for(int j=i;j<points.length;j++){
                if(j==i)continue;
                int x=points[i][0]-points[j][0];
                int y=points[i][1]-points[j][1];
                int key=x*x+y*y;
                map.put(key,map.getOrDefault(key,0)+1);
            }
            for(int count:map.values()){
                res+=count*(count-1);
            }
            map.clear();
        }
        return res;
    }
}
