package main.java.bupt.wxy.bitmanipulation.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 1/13/17.
 405. Convert a Number to Hexadecimal   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 13216
 Total Submissions: 32646
 Difficulty: Easy
 Contributors: Admin
 Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

 Note:

 All letters in hexadecimal (a-f) must be in lowercase.
 The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 The given number is guaranteed to fit within the range of a 32-bit signed integer.
 You must not use any method provided by the library which converts/formats the number to hex directly.
 Example 1:

 Input:
 26

 Output:
 "1a"
 Example 2:

 Input:
 -1

 Output:
 "ffffffff"
 */
public class Solution_405 {
    static Map<Integer,String> map=new HashMap<>();
    static {
        for(int i=0;i<10;i++)map.put(i,Integer.toString(i));
        for(int i=10;i<16;i++)
            map.put(i,""+(char)('a'+(i-10)));
    }

    public String toHex(int num) {
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<8;i++){
            sb.append(map.get(num&15));
            num>>=4;
        }
        sb=sb.reverse();
        while (sb.length()>1&&sb.charAt(0)=='0')sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args){
    }

}
