package main.java.wxy.engineering.wangyi;


import java.util.*;

public class Main{
    static char[] chars;
    static int res = 0;
    static int n;

    static int getCount(String str){
        List<Integer> indexs = new ArrayList<>();
        chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='X')indexs.add(i);
        }
        backtracking(0, indexs);
        return res;

    }
    static void backtracking(int i, List<Integer> indexs){
        if(i==indexs.size()){
            Long num = Long.parseLong(new String(chars));
            if(num%n==0)res++;
            return;
        }
        int index = indexs.get(i);
        for(int j=0; j<10; j++){
            chars[index] = (char)('0'+j);
            backtracking(i+1, indexs);
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        n = in.nextInt();
        System.out.println(getCount(str));
    }
}
