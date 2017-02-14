package main.java.bupt.wxy.greedy;

/**
 * Created by xiyuanbupt on 1/9/17.
 134. Gas Station
 Total Accepted: 75997
 Total Submissions: 265975
 Difficulty: Medium
 Contributors: Admin
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */

/**
 * 觉得就是On2遍历数组
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int start=gas.length-1;
        int end=0;
        int sum=gas[start]-cost[start];
        while (start>end){
            if(sum>=0){
                sum+=gas[end]-cost[end];
                ++end;
            }
            else {
                --start;
                sum+=gas[start]-cost[start];
            }
        }
        return sum>=0?start:-1;
    }
}
