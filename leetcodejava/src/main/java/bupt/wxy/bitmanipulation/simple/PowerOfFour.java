package bupt.wxy.bitmanipulation.simple;

/**
 * Created by xiyuanbupt on 3/2/17.
 342. Power of Four Add to List

 Contributors: Admin
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    // 21.63%
    public boolean isPowerOfFour(int num) {
        // 正数, bit位只有一位, 并且这个bit位在特定的位置
        return num>0&&(num&(num-1))==0&&(num&0x55555555)!=0;
    }
}
