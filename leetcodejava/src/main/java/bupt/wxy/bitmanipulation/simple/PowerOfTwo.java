package bupt.wxy.bitmanipulation.simple;

/**
 * Created by xiyuanbupt on 3/1/17.
 231. Power of Two Add to List

 Contributors: Admin
 Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {

    // 22.21%
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;

        while (n!=0){
            if((n&1)==1){
                return n>>>1==0;
            }
            n=n>>>1;
        }
        // 0 不是
        return false;
    }
}
