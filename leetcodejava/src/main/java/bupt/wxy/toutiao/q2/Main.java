package bupt.wxy.toutiao.q2;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 8/22/17.
 */
public class Main {

    static long[] sums;
    static int[] arr;

    public static void main(String[] bbs){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = in.nextInt();
        }
        sums = new long[n];
        sums[0] = arr[0];
        for(int i = 1; i<sums.length; i++){
            sums[i] = sums[i-1] + arr[i];
        }
        System.out.print(getMax(0, sums.length - 1));
    }

    public static long getMax(int start, int end){
        if(start > end)return Integer.MIN_VALUE;
        if(start == end)return arr[start] * arr[start];
        long sum = sums[end] - sums[start] + arr[start];
        int min_index = findMin(start, end);
        long r_l_max = Math.max(getMax(start, min_index - 1), getMax(min_index + 1, end));
        return Math.max(r_l_max, sum * arr[min_index]);
    }

    public static int findMin(int start, int end){
        int res = start;
        for(start++;start<=end;start++){
            if(arr[start] < arr[res]){
                res = start;
            }
        }
        return res;
    }
}
