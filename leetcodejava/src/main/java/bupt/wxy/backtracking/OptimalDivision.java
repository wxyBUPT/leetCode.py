package main.java.bupt.wxy.backtracking;

/**
 * Created by xiyuanbupt on 4/16/17.
 553. Optimal Division My SubmissionsBack To Contest
 User Accepted: 4
 User Tried: 9
 Total Accepted: 4
 Total Submissions: 12
 Difficulty: Medium
 Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

 However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

 Example:
 Input: [1000,100,10,2]
 Output: "1000/(100/10/2)"
 Explanation:
 1000/(100/10/2) = 1000/((100/10)/2) = 200
 However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 since they don't influence the operation priority. So you should return "1000/(100/10/2)".

 Other cases:
 1000/(100/10)/2 = 50
 1000/(100/(10/2)) = 50
 1000/100/10/2 = 0.5
 1000/100/(10/2) = 2
 Note:

 The length of the input array is [1, 10].
 Elements in the given array will be in range [2, 1000].
 There is only one optimal division for each test case.
 */

import java.util.*;

/**
 * 个人感觉是使用backtracking决定操作顺序, 目前没开放discuss 不知道最优答案
 */
public class OptimalDivision {

    double minValue = Integer.MIN_VALUE;
    StringBuilder res = null;

    public String optimalDivision(int[] nums) {
        List<Double> lis_nums = new LinkedList<>();
        List<StringBuilder> ress = new LinkedList<>();
        for(int i:nums){
            lis_nums.add((1.0)*i);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            ress.add(sb);
        }
        backtracking(lis_nums, ress);
        return rmRedu(res);

    }

    public String rmRedu(StringBuilder s){
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toString().toCharArray();
        int len=chars.length;
        int l_count = 0;
        for(int i = 0; i<len; i++){
            char c = chars[i];
            if(c == ')'){
                if(l_count>0){
                    l_count--;
                }else {
                    sb.append(c);
                }
            }
            else if(c == '('){
                if(i!=0&&chars[i-1]=='('){
                    l_count++;
                }else {
                    sb.append(c);
                }
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    void backtracking(List<Double> nums, List<StringBuilder> ress){
        if(ress.size()==1){
            if(nums.get(0)>minValue){
                res = ress.get(0);
                minValue = nums.get(0);
            }
            return;
        }

        int len = nums.size();
        for(int i = 1; i<len; i++){
            List<Double> next_nums = new LinkedList<>(nums);
            List<StringBuilder> next_ress = new LinkedList<>(ress);
            double pre_int = next_nums.remove(i-1);
            double next_int = next_nums.remove(i-1);
            next_nums.add(i-1, pre_int/next_int);
            StringBuilder pre_str = next_ress.remove(i-1);
            StringBuilder next_str = next_ress.remove(i-1);
            StringBuilder next = new StringBuilder();
            if(i==1){
                next.append(pre_str).append("/").append(next_str);
                next_ress.add(0, next);
            }else {
                next.append("(").append(pre_str).append("/").append(next_str).append(")");
                next_ress.add(i-1, next);
            }
            backtracking(next_nums, next_ress);
        }
    }

    public static void main(String[] args){
        OptimalDivision op = new OptimalDivision();
        int[] ques = {501,201,306,858,745,305,411,763,909,455};
        String res = op.optimalDivision(ques);
        System.out.println(res);
    }
}
