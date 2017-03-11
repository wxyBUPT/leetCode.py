
package main.java.bupt.wxy.aliCode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    /**
     * 针对数组值元素是否可以为负值我有两种解法
     * 下面是O(n*n)的想法
     * @param A
     * @return
     */
    static boolean resolveOn_2(int[] A) {
        int len=A.length;
        // left 数组记录A从左到右的和
        long[] left=new long[len];
        // right 数组记录A从右到左的和
        long[] right=new long[len];
        left[0]=A[0];
        right[len-1]=A[len-1];
        for(int i=1;i<A.length;i++){
            left[i]=left[i-1]+A[i];
            right[len-1-i]=right[len-i]+A[len-1-i];
        }
        // 两点逼近
        int i=0,j=len-1;
        while (i<j-5){
            // 遇到左面和右面相等的情况, 开始在中间找等分点
            if(left[i]==right[j]){
                for(int k=i+3;k<=j-3;k++){
                    if(left[k-1]==left[i+1]+left[i]&&right[k+1]==right[j-1]+right[j])return true;

                }
            }
            // 左面的和大于右面的和, 右面的j向中间逼近
            else if(left[i]>right[j])j--;
            else i++;
        }
        return false;
    }

    /**
     * 上题目的解法可以使用Map做优化
     * @param A
     * @return
     */
    static boolean resolve(int[] A) {
        Map<Integer, Integer> map=new HashMap<>();
        int[] sums=new int[A.length];
        int tmp=0;

        for(int i=0;i<A.length;i++){
            tmp+=A[i];
            sums[i]=tmp;
            map.put(tmp,i);
        }

        for(int i=1;i<A.length;i++){
            int sum=sums[i]-A[i];
            if(map.containsKey(sum+sums[i])){
                int j=map.get(sum+sums[i])+1;
                if(j<A.length&&map.containsKey(sum+sums[j])){
                    int k=map.get(sum+sums[j])+1;
                    if(j<A.length&&sums[sums.length-1]-sums[j]==sum)return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}