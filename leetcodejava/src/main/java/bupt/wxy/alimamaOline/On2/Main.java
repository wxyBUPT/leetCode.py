package main.java.bupt.wxy.alimamaOline.On2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    static Set<String> ops = new HashSet<>();
    static {
        ops.add("*");
        ops.add("^");
        ops.add("+");

    }

    // write your code here
    public static int resolve(String expr) {
        String[] strs = expr.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(String str:strs){
            if(ops.contains(str)){
                if(str.equals("*")){
                    if(stack.size()<2)return -1;
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.add(right * left);
                }else if(str.equals("^")){
                    if(stack.size()<1)return -1;
                    stack.add(stack.pop()+1);
                }else {
                    if(stack.size()<2)return -1;
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.add(right + left);
                }
            }else if(!str.equals("")) {
                if(stack.size()>15)return -2;
                stack.add(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }
}
