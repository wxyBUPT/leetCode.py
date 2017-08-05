package wxy.engineering.ms2.q1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 4/8/17.
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class Maintt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] points = new Point[n];
        for(int i = 0;i<n;i++){
            points[i] = new Point(in.nextInt(), in.nextInt());
        }
        Maintt main = new Maintt();
        System.out.print(main.maxPoints(points));
    }

    public int maxPoints(Point[] points) {
        if (points==null) return 0;
        if (points.length<=2) return points.length;

        Map<Double, Integer> map = new HashMap<>();
        int result=0;
        for (int i=0;i<points.length;i++){
            map.clear();
            for (int j=i+1;j<points.length;j++){
                Point x = points[i];
                Point y = points[j];
                if(x.x == y.x){
                    if(!map.containsKey(Double.MAX_VALUE))map.put(Double.MAX_VALUE, 0);
                    map.put(Double.MAX_VALUE, map.get(Double.MAX_VALUE) + 1);
                    continue;
                }

                double slope = (double)(x.y-y.y) / (double)(x.x - y.x);
                if(!map.containsKey(slope)){
                    map.put(slope, 0);
                }
                map.put(slope, map.get(slope)+1);
            }
            for(Integer count:map.values()){
                result += count;
            }
        }
        return result;
    }
}
