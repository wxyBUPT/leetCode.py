package wxy.engineering.ms2.q2;
/**
 描述
 There are N jobs to be finished. It takes a robot 1 hour to finish one job.

 At the beginning you have only one robot. Luckily a robot may build more robots identical to itself. It takes a robot Q hours to build another robot.

 So what is the minimum number of hours to finish N jobs?

 Note two or more robots working on the same job or building the same robot won't accelerate the progress.

 输入
 The first line contains 2 integers, N and Q.

 For 70% of the data, 1 <= N <= 1000000

 For 100% of the data, 1 <= N <= 1000000000000, 1 <= Q <= 1000

 输出
 The minimum number of hours.

 样例输入
 10 1
 样例输出
 5
 */

import java.util.Scanner;

/**
 * 并且明显是开始阶段创建尽可能多的机器人
 * 和dp没有太大的关系
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        int Q = in.nextInt();
        calc(N, Q);
    }

    public static void calc(long N, int Q){
        long min = Long.MAX_VALUE;
        for(int i = 1; i<N; i++){
            long count = getFinishTimeWithNRobot(N, Q, i);
            if(count <= min)min = count;
            else break;
        }
        System.out.print(min);
    }

    /**
     * 最后阶段有i个机器人需要的时间
     * @param N
     * @param Q
     * @param i
     */
    public static long getFinishTimeWithNRobot(long N, int Q, int i){
        int prepareCount = 0;
        int robotCount = 1;
        while (robotCount < i){
            int nextRobotCount = 2 * robotCount;
            if(nextRobotCount >= i){
                // 有一些robot并没有繁殖, 而是做工作了
                N -= (robotCount - (i - robotCount)) * Q;
                robotCount = i;
            }else {
                robotCount = nextRobotCount;
            }
            prepareCount++;
        }
        return prepareCount * Q  + N/i + ((N%i) == 0?0:1);
    }
}
