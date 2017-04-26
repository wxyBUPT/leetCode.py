package main.java.bupt.wxy.stack;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 2/2/17.
 20. Valid Parentheses
 Difficulty: Easy
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    /**
     * Judge string is valid Parentheses
     * 75.69%
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(char c:chars){
            switch (c){
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if(stack.isEmpty()||stack.pop()!='{')return false;
                    break;
                case ']':
                    if(stack.isEmpty()||stack.pop()!='[')return false;
                    break;
                case ')':
                    if(stack.isEmpty()||stack.pop()!='(')return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
