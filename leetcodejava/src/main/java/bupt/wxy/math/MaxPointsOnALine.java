package main.java.bupt.wxy.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiyuanbupt on 2/14/17.
 149. Max Points on a Line
 Description  Submission  Solutions  Add to List
 Total Accepted: 73810
 Total Submissions: 473822
 Difficulty: Hard
 Contributors: Admin
 Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

 Subscribe to see which companies asked this question.
 */
public class MaxPointsOnALine {

    // 没有做出来........
    // 传说中可以不使用斜率什么的
    static class Point{
        int x;
        int y;
        Point(){
            x=0;y=0;
        }
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    // 不处理斜率为正无穷的点
    static class Line{
        float k;
        float c;
        Line(){
            k=0;
            c=0;
        }

        Line(Point a, Point b) throws IllegalArgumentException{
            /**
            if(a.x==b.x){
                throw new IllegalArgumentException("还不能处理斜率为正无穷的直线");
            }
             **/
            if(a.x==b.x){
                k=Float.MAX_VALUE;
                c=a.x;
                return;
            }

            k=(a.y-b.y)/(a.x-b.x);
            c=a.y-k*(a.x);
        }
    }

    // 计算两点之间的斜率和截距
    public int maxPoints(Point[] points){
        if(points.length==0)return 0;
        Map<Float,Map<Float,Set<Point>>> map=new HashMap<>();
        for(int i=0;i<points.length;i++)
            for(int j=i+1;j<points.length;j++){
                Point a=points[i];
                Point b=points[j];

                Line line=new Line(a,b);
                if(!map.containsKey(line.k))map.put(line.k,new HashMap<>());
                Map<Float,Set<Point>> point_map=map.get(line.k);
                if(!point_map.containsKey(line.c))point_map.put(line.c,new HashSet<>());
                point_map.get(line.c).add(a);
                point_map.get(line.c).add(b);
            }
        int res=1;
        for(Map<Float,Set<Point>> map_point:map.values()){
            for(Set<Point> p:map_point.values()){
                res=Math.max(p.size(),res);
            }
        }

        return res;
    }

    public static void main(String[] args){
        Point a=new Point(0,0);
        Point b=new Point(0,0);
        Set<Point> points=new HashSet<>();
        points.add(a);
        points.add(b);
        System.out.println(points.size());
    }
}
