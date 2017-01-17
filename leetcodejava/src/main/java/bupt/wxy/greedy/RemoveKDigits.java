package main.java.bupt.wxy.greedy;

/**
 * Created by xiyuanbupt on 1/9/17.
 402. Remove K Digits
 Total Accepted: 11672
 Total Submissions: 44687
 Difficulty: Medium
 Contributors: Admin
 Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Note:
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.
 Example 1:

 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 Example 2:

 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 Example 3:

 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */

/**
 * 使用贪心算法, 因为数的位数是不变的,所以如果前面比后面大的数组都删除了
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        char[] nums=num.toCharArray();
        int len=nums.length;
        while (k>0){
            k--;
            // 找到比后面大的数字
            int rm_index=0;
            for (;rm_index<len;rm_index++){
                if(rm_index==len-1||nums[rm_index]>nums[rm_index+1])break;
            }
            len--;
            for(;rm_index<len;rm_index++){
                nums[rm_index]=nums[rm_index+1];
            }
        }
        int start=0;
        while (start<len&&nums[start]=='0')start++;
        StringBuilder sb=new StringBuilder();
        for(;start<len;start++){
            sb.append(nums[start]);
        }
        if(sb.length()==0)sb.append(0);
        return sb.toString();
    }
}
