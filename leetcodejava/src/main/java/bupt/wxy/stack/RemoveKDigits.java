package bupt.wxy.stack;

/**
 * Created by xiyuanbupt on 1/9/17.
 402. Remove K Digits
 Difficulty: Medium

 Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Note:
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.
 Example 1:

 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 Example 2:

 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 Example 3:

 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */

/**
 * 本题目使用普通的方法也能解决, 但是明显使用stack更加节省时间
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int digits=num.length()-k;
        char[] stk=new char[num.length()];
        int top=0;

        for(char c:num.toCharArray()){
            while (top>0&&stk[top-1]>c&&k>0){
                top-=1;
                k-=1;
            }
            stk[top++]=c;
        }
        int inx=0;
        while (inx<digits&&stk[inx]=='0')inx++;
        return inx==digits?"0":new String(stk,inx,digits-inx);
    }
}
