package main.java.bupt.wxy.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 3/9/17.
 * 282. Expression Add Operators Add to List
 Difficulty: Hard
 Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +,
 -, or * between the digits so they evaluate to the target value.

 Examples:
 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []
 */
public class ExpressionAddOperators {

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
