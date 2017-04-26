package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 3/24/17.
 171. Excel Sheet Column Number
 Difficulty: Easy
 Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        int weight = 26;
        int res = 0;
        for(char c:s.toCharArray()){
            res = res * weight + c -'A' + 1;
        }
        return res;
    }
}
