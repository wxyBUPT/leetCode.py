package main.java.bupt.wxy.indeed.round2.Q4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 5/13/17.
 * 反正是某种数学关系, 有时间想想
 */
public class Main {

    static class House{
        long pos, val;

        public House(long pos, long val) {
            this.pos = pos;
            this.val = val;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long L = in.nextLong();
        int N = in.nextInt();
        House[] houses = new House[N];
        for(int i = 0;i<N; i++){
            House house = new House(in.nextLong(), in.nextLong());
            houses[i] = house;
        }
        Arrays.sort(houses, new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                if(o1.pos == o2.pos)return 0;
                return o1.pos < o2.pos ? -1:1;
            }
        });

    }
}
