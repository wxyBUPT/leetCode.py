package main.java.bupt.wxy.wangyi;

import java.util.*;

/**
 * Created by xiyuanbupt on 3/25/17.

 */
public class Management {

    // n个工程师, 是否被用到
    static boolean[] workder_used ;
    // 六种工作能够胜任的工程师
    static List<List<Integer>> work_enginers;
    static int res = 0;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        workder_used = new boolean[n];
        work_enginers = new ArrayList<>(6);
        for(int i=0;i<6; i++){
            work_enginers.add(new ArrayList<>());
        }
        String line;
        // 输入工程师胜任的工作
        for(int i=0;i<n;i++){
            line = in.nextLine();
            for(Character c:line.toCharArray()){
                int work = Integer.parseInt(c.toString());
                work_enginers.get(work).add(i);
            }
        }
        backtracking(0);
        System.out.println(res);
    }

    public static void backtracking(int i){
        if(i==6){
            res++;
            return;
        }
        List<Integer> workers = work_enginers.get(i);
        for(int workder:workers){
            if(!workder_used[workder]){
                workder_used[workder] = true;
                backtracking(i+1);
                workder_used[workder] = false;
            }
        }
    }
}
