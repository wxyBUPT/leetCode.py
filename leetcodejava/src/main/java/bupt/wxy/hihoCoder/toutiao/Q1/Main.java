package main.java.bupt.wxy.hihoCoder.toutiao.Q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void solve(int[] nums){
        int n = nums.length;
        int start = -1;
        int end = -1;
        int maxDiff = -1;
        int currStart = 0;
        for(int i=1;i<n;){
            boolean inc = false;
            boolean dec = false;
            while (i<n && nums[i]>nums[i-1]){
                i++;
                inc = true;
            }
            while (i<n && nums[i]<nums[i-1]){
                i++;
                dec = true;
            }
            if(inc && dec){
                if(i-currStart>maxDiff){
                    maxDiff = i - currStart;
                    start = currStart;
                    end = i-1;
                }
            }
            currStart = i - 1;
        }
        System.out.print(start + " " + end);
    }

    public static void main(String[] args){

        int start = -1;
        int end = -1;
        int maxDiff = -1;
        int currStart = 0;

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int pre = in.nextInt();
        int tmp ;
        for(int i=1;i<n;){
            boolean inc = false;
            boolean dec = false;
            while ((tmp=in.nextInt())>pre){
                i++;
                pre = tmp;
                inc = true;
            }
            while ((tmp=in.nextInt())<pre){
                i++;
                pre = tmp;
                dec = true;
            }
            if(inc && dec){
                if(i-currStart>maxDiff){
                    maxDiff = i - currStart;
                    start = currStart;
                    end = i-1;
                }
            }
            currStart = i - 1;
        }
        System.out.print(start + " " + end);
    }
}
