package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 3/10/17.
 413. Arithmetic Slices
 Difficulty: Medium
 A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

 For example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.


 Example:

 A = [1, 2, 3, 4]

 return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices {

    // 13.54%
    public int numberOfArithmeticSlices(int[] A) {
        // 首先求最长有多少连接
        int len=A.length;
        if(len<3)return 0;
        int[] maxConnect=new int[len];
        int max=2;
        maxConnect[0]=1;
        maxConnect[1]=2;
        for(int i=2;i<len;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                maxConnect[i]=maxConnect[i-1]+1;
                max=Math.max(maxConnect[i],max);
            }else {
                maxConnect[i]=2;
            }
        }
        int res=0;
        for(int connectCount:maxConnect){
            if(connectCount>2)res+=connectCount-2;
        }
        return res;
    }
}
