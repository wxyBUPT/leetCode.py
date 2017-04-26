package main.java.bupt.wxy.sort;

/**
 * Created by xiyuanbupt on 4/15/17.
 556. Next Greater Element III
 Difficulty: Medium
 Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

 Example 1:
 Input: 12
 Output: 21
 Example 2:
 Input: 21
 Output: -1
 */

import java.util.Arrays;

/**
 * 从后面找比当前位置大的数, 然后排序
 */
public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        String MAX_STR = Integer.toString(Integer.MAX_VALUE);
        String digit = Integer.toString(n);
        char[] digits = digit.toCharArray();
        for(int i=digits.length - 2; i>=0; i--){
            if(canSort(digits, i)){
                String curr = new String(digits);
                if(curr.length() == MAX_STR.length() && curr.compareTo(MAX_STR)>0)return -1;
                return Integer.parseInt(curr);
            }
        }
        return -1;
    }

    boolean canSort(char[] digits, int index){
        // 找当前位置之后的最大最小值
        int highter_index = -1;
        for(int i = index + 1, len = digits.length; i<len; i++){
            // 当遇到比index位置大的点
            if(digits[i] > digits[index]){
                if(highter_index == -1 || digits[i] < digits[highter_index])highter_index = i;
            }
        }
        // not found
        if(highter_index == -1) return false;
        swap(digits, index, highter_index);
        // 因为要获得最小值, 所以对后面的点排序
        Arrays.sort(digits, index + 1, digits.length);
        return true;
    }

    void swap(char[] digits, int i, int j) {
        char tmp = digits[i];
        digits[i] = digits[j];
        digits[j] = tmp;
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
    }
}
