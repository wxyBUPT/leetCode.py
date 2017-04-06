package main.java.wxy.engineering.ljava;
import java.util.*;

public class Range{
    static Set<Character> ops = new HashSet<>();
    static {
        ops.add('*');
        ops.add('-');
        ops.add('+');
    }

    static int calculate(String s){
        int res = 0;
        int pre = 0;
        int i = 0, j=getNextIndex(s, 0);
        String next = "+"+s.substring(0,j);
        while(j<s.length()){
            int num = Integer.parseInt(s.substring(i,j));
            char op = next.charAt(0);
            if(op=='+'){
                res += num;
                pre = num;
            }else if(op == '-'){
                res -= num;
                pre = -num;
            }
            else{
                res -= pre;
                pre = pre * num;
                res += pre;
            }
            i = j;
            j = getNextIndex(s,j);
        }
        return res;
    }

    static int getNextIndex(String s, int i){
        int j = i+1;
        int len = s.length();
        while(j<len&&!ops.contains(s.charAt(j))){
            j++;
        }
        return j;
        //i==0?"+"+s.subString(0,j):s.subString(i,j);
    }
}