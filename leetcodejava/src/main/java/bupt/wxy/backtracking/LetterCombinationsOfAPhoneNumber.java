package main.java.bupt.wxy.backtracking;

import java.util.*;

/**
 * Created by xiyuanbupt on 2/1/17.
 17. Letter Combinations of a Phone Number   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 124515
 Total Submissions: 381428
 Difficulty: Medium
 Contributors: Admin
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {

    static Map<Character,String> map=new HashMap<>();
    static {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<>();
        List<String> res = new LinkedList<>();
        backtracking(digits,0,new StringBuilder(),res);
        return res;
    }

    void backtracking(String digits, int index, StringBuilder curr, List<String> res){
        if(index==digits.length()){
            res.add(curr.toString());
            return;
        }

        char digit = digits.charAt(index);
        for(char c:map.get(digit).toCharArray()){
            curr.append(c);
            backtracking(digits,index+1,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
