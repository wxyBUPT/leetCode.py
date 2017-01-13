package main.java.bupt.wxy.bitmanipulation.simple;

/**
 * Created by xiyuanbupt on 1/13/17.
 */
public class Solution_467 {

    public int findComplement(int num) {
        return ~num + (Integer.highestOneBit(num)<<1);
    }
}
