package main.java.bupt.wxy.hihoCoder.mc2017.ParenthesesSequence;

import java.util.Scanner;
import java.util.Stack;

public class Main{

    static public void printRes(String s) {
        Stack<Integer> stack=new Stack<>();
        char[] strs = s.toCharArray();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(strs[i]=='(')stack.push(i);
            else {
                if(!stack.isEmpty()) {
                    if (strs[stack.peek()] == '(') stack.pop();
                    else stack.push(i);
                }
                else stack.push(i);
            }
        }

        int[] pos= new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            pos[i] = stack.get(i);
        }
        int len = pos.length;
        int right_start = 0;
        while (right_start<len && strs[pos[right_start]]==')')right_start++;
        int res = 0;
        for(int i=0;i<right_start;i++){
            int index = pos[i];
            for(int j=0;j<=index;j++){
                if(strs[j]==')')res++;
            }
        }
        for(int i=right_start;i<len; i++){
            int index = pos[i];
            for(int j=index;j<strs.length;j++){
                if(strs[j]=='(')res++;
            }
        }
        System.out.println(len + " " + res);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        printRes(in.nextLine());
    }

}
