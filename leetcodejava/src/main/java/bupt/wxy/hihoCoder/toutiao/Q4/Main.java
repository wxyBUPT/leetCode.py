package main.java.bupt.wxy.hihoCoder.toutiao.Q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by xiyuanbupt on 3/30/17.
 * 首先想到的是暴力求解, 之后想到可能是二叉查找树问题
 * 首先完成暴力方法
 */

class Interval{
    int start;
    int end;
    Interval(){start=0;end=0;}
    Interval(int s,int e){
        start=s;
        end=e;
    }
}

public class Main {


    public static void main(String[] args){
        List<Interval> intervals;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int q = in.nextInt();
        intervals = new ArrayList<>(n);
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for(int i=0;i<n;i++){
            nums1[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            nums2[i] = in.nextInt();
        }
        sort(nums1, nums2, n);



        for(int j=0;j<q;j++){
            int count = 0;
            int x = in.nextInt();
            int y = in.nextInt();
            // 对nums1 执行左查找
            int start = binarySearch(nums1, 0, n, x);
            for(int k=start;k<n;k++){
                if(nums2[k]>=y)count++;
            }
            System.out.println(count);
        }
    }

    // 寻找左插入位置
    static int binarySearch(int[] sums, int lo, int hi, int target){
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(sums[mid]<target)lo=mid+1;
            else hi=mid;
        }
        return lo;
    }

    /**
     * 插入排序
     * @param nums1
     * @param nums2
     */
    static void sort(int[] nums1, int[] nums2, int n){
        int tmp;
        for(int i=1;i<n;i++){
            int j=i;
            while (j>0&&nums1[j]<nums1[j-1]){
                tmp = nums1[j];
                nums1[j] = nums1[j-1];
                nums1[j-1] = tmp;
                tmp = nums2[j];
                nums2[j] = nums2[j-1];
                nums2[j-1] = tmp;
                j--;
            }
        }
    }
}
