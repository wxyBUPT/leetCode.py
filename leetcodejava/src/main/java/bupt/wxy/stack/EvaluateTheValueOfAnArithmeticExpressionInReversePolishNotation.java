package bupt.wxy.stack;

/**
 * Created by xiyuanbupt on 1/11/17.
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

import java.util.*;

/**
 * 计算逆波兰表达式的值
 */
public class EvaluateTheValueOfAnArithmeticExpressionInReversePolishNotation {

    static Set<String> operators=new HashSet<>();
    static {
        operators.addAll(Arrays.asList("*","+","-","/"));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums=new Stack<>();
        for(String token:tokens){
            if(operators.contains(token)){
                switch (token){
                    case "*":
                        nums.push(nums.pop()*nums.pop());
                        break;
                    case "-":
                        nums.push(-nums.pop()+nums.pop());
                        break;
                    case "+":
                        nums.push(nums.pop()+nums.pop());
                        break;
                    case "/":
                        int b=nums.pop();
                        int a=nums.pop();
                        nums.push(a/b);
                        break;
                    default:
                        break;
                }
            }
            else {
                nums.push(Integer.parseInt(token));
            }
        }
        return nums.peek();
    }
}
