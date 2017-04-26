package main.java.bupt.wxy.wangyi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiyuanbupt on 3/25/17.
 网易笔试题, 计算表达式的值
 */
public class Calculator {

    long eval= 0;
    long multed = 0;
    static Set<Character> ops = new HashSet<>();
    static {
        ops.add('+');
        ops.add('-');
        ops.add('*');
    }


    private long calculate(String num){
        helper(num, 0);
        return eval;
    }

    private void helper(String num, int pos){
        if(pos==num.length())return;
        int index = findIndex(num, pos);
        long curr = Long.parseLong(num.substring(pos, index));
        return ;

    }

    // 找到符号的位置
    private int findIndex(String num, int pos){
        int len = num.length();
        for(int i=pos; i<len; i++){
            char c = num.charAt(i);
            if(ops.contains(c))return i;
        }
        return len;
    }


    // 并不是自己想到的办法
    public List<String> addOperators(String num, int target) {
        List<String> ret=new ArrayList<>();
        if(num==null||num.length()==0)return ret;
        helper(ret,"",num,target,0,0,0);
        return ret;
    }

    public void helper(List<String> ret, String path, String num, int target, int pos, long eval, long multed){
        if(pos==num.length()){
            if(target==eval)ret.add(path);
            return;
        }
        for(int i=pos;i<num.length();i++){
            // 第一个是零后面再算就没有意义了
            if(i!=pos&&num.charAt(pos)=='0')break;
            long cur=Long.parseLong(num.substring(pos,i+1));
            if(pos==0)helper(ret,path+cur,num,target,i+1,cur,cur);
            else {
                helper(ret, path+"+"+cur,num,target,i+1,eval+cur,cur);
                helper(ret,path+"-"+cur,num,target,i+1,eval-cur,-cur);
                helper(ret,path+"*"+cur,num,target,i+1,eval-multed+multed*cur,multed*cur);
            }
        }
    }

}
