package main.java.bupt.wxy.bitmanipulation;

/**
 * Created by xiyuanbupt on 1/12/17.
 397. Integer Replacement
 Total Accepted: 13215
 Total Submissions: 45280
 Difficulty: Medium
 Contributors: Admin
 Given a positive integer n and you can do operations as follow:

 If n is even, replace n with n/2.
 If n is odd, you can replace n with either n + 1 or n - 1.
 What is the minimum number of replacements needed for n to become 1?

 Example 1:

 Input:
 8

 Output:
 3

 Explanation:
 8 -> 4 -> 2 -> 1
 Example 2:

 Input:
 7

 Output:
 4

 Explanation:
 7 -> 8 -> 4 -> 2 -> 1
 or
 7 -> 6 -> 3 -> 2 -> 1

 */
public class IntegerReplacement {

    // 使用long 通过了
    // 使用int 会发生溢出的情况
    // 另外还可以使用无符号左移位 >>>
    public int integerReplacement(long n) {

        int res=0;
        while (n!=1){
            if(n==3){
                res+=2;
                break;
            }
            res++;
            if((n&1)==0)n>>=1;
            else {
                if((n&2)==2)n+=1;
                else n-=1;
            }
        }
        return res;
    }
}
