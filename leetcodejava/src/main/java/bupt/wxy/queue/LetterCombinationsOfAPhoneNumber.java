package main.java.bupt.wxy.queue;

/**
 * Created by xiyuanbupt on 2/1/17.
 17. Letter Combinations of a Phone Number
 Difficulty: Medium
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

import java.util.*;

/**
 * 首先想到的是回溯法
 * 但是看discuss里面有使用FIFO实现
 */
public class LetterCombinationsOfAPhoneNumber {

    // 47%
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<>();
        Queue<String> res=new LinkedList<>();
        res.add("");
        String[] map={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


        for(int i=0;i<digits.length();i++){
            int index=Character.getNumericValue(digits.charAt(i));
            while (res.peek().length()==i){
                String t=res.remove();
                for(char c:map[index].toCharArray())res.add(t+c);
            }
        }
        return new ArrayList<>(res);
    }

}
