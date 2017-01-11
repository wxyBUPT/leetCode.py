package main.java.bupt.wxy.sort;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/11/17.
 179. Largest Number   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 63776
 Total Submissions: 297897
 Difficulty: Medium
 Contributors: Admin
 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.

 Credits:
 */
public class Solution_179 {

    public String largestNumber(int[] nums) {
        List<String> strs= new ArrayList<>();
        for(int num:nums)strs.add(Integer.toString(num));
        Collections.sort(strs, new Comparator<String>() {
            // 你觉得哪个更大????????? 自己的想法简直不能看
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }
        });
        if(strs.get(0).equals("0"))return "0";

        StringBuilder sb=new StringBuilder();
        for(String s:strs)sb.append(s);

        return sb.toString();

    }

    public static void main(String[] args){
        System.out.println("89".compareTo("83"));
        System.out.println("83".compareTo("8"));
    }
}
