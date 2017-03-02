package main.java.bupt.wxy.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 3/1/17.
 阿里内推的一道题目
 */
public class AliOnline {

    public boolean solve(int[] A) {
        int len = A.length;
        long[] left = new long[len];
        long[] right = new long[len];
        left[0] = A[0];
        right[len - 1] = A[len - 1];
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] + A[i];
            right[len - 1 - i] = right[len - i] + A[len - 1 - i];
        }

        // 原题中是所有数都是正数
        int i = 0, j = len - 1;
        while (i < j - 5) {
            if (left[i] == right[j]) {
                for (int k = i + 3; k <= j - 3; k++) {
                    if (left[k - 1] == left[i + 1] + left[i] && right[k + 1] == right[j - 1] + right[j]) return true;
                }
            } else if (left[i] > right[j]) j--;
            else i++;
        }
        return false;
    }
        // 对于有负数的时间复杂度是 O(n*n)
        /**
        int i=1;
        int j;
        for(;i<len-6;i++)
            for(j=len-1;j>i+5;j--){
                if(left[i]==right[j]){
                    // 两边相等了,开始找中间的分割点
                    //left[k-1]=left[i+1]+left[i]
                    //right[k+1]=right[j-1]+right[j]
                for(int k=i+3;k<=j-3;k++){
                        if(left[k-1]==left[i+1]+left[i]&&right[k+1]==right[j-1]+right[j])return true;
                    }

                }
            }
        return false;
         **/

    public static void main(String[] args){
        AliOnline aliOnline=new AliOnline();
        int[] A={2,5,1,1,1,1,4,1,7,3,7};
        System.out.println(aliOnline.solve(A));
        System.out.println(Long.MAX_VALUE);
    }
}
