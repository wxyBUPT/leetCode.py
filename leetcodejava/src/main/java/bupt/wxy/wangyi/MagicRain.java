package main.java.bupt.wxy.wangyi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 3/25/17.

 */
public class MagicRain {


    public static void main(String[] args){
        int N = 39;
        int[] dp = new int[N];
        new HashSet<>();
        for(int i = N-1;i>0; --i){
            dp[i] = 1;

        }
        System.out.print('1'-'0');
        Scanner in = new Scanner(System.in);
        in.nextByte();
        int n, k;
        n = in.nextInt();
        k = in.nextInt();
        "".toCharArray();
        in.hasNextLine();
        int[] nums = new int[n];
        for(int i = 0;i<n; i++){
            nums[i] = in.nextInt();
        }
        int[] res = changeN(nums, k);
        for(int i=0;i<res.length - 1; i++){
            System.out.print(res[i] + " ");
        }
        System.out.print(res[nums.length-1]);
    }

    public static int[] changeN(int[] nums, int k){
        while (k>0){
            k --;
            int index_0 = nums[0];
            for(int i=0, len = nums.length; i<len; i++){
                if(i<len-1){
                    int tmp = nums[i] + nums[i+1];
                    if(tmp/100==1)tmp = tmp % 100;
                    nums[i] = tmp;
                }
                else {
                    int tmp = nums[i] + index_0;
                    if(tmp/100==1)tmp = tmp%100;
                    nums[i] = tmp;
                }
            }
        }
        return nums;
    }

}
