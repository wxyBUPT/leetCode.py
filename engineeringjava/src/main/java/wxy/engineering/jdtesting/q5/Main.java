package wxy.engineering.jdtesting.q5;

import java.util.*;

/**
 * Created by xiyuanbupt on 4/7/17.
 */
class Interval{

    int start, end;
    Set<Integer> cars;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
        cars = new HashSet<>();
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for(int i = 0; i < n; i++){
            starts[i] = in.nextInt();
            ends[i] = in.nextInt();
        }
        solve(starts, ends);
    }

    public static void solve(int[] starts, int[] ends){
        TreeMap<Integer, Interval> tree = new TreeMap<>();
        for(int i=0, len = starts.length; i<len; i++){
            
        }
    }
}
