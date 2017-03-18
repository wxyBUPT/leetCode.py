package main.java.bupt.wxy.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 3/11/17.
 202. Happy Number
 Difficulty: Easy
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 注意, 后面的二都代表平方的意思
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        if(n<1)return false;
        Set<Integer> seen=new HashSet<>();
        while (n!=1){
            if(seen.contains(n))return false;
            seen.add(n);
            n=getNext(n);
        }
        return true;
    }

    int getNext(int n){
        int next=0;
        while (n!=0){
            int tmp=n%10;
            next+= tmp*tmp;
            n=n/10;
        }
        return next;
    }
}
