package main.java.wxy.engineering;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 3/2/17.
 */
public class Learn {

    public static void main(String[] args){
        Integer a = new Integer(1);
        System.out.println(a.equals(1));
        System.out.println(a==1);
        Integer b=new Integer(1000000);
        System.out.println(b==1000000);
        Set<Integer> set =new HashSet<>();
        System.out.println(Integer.MAX_VALUE);
    }
}
