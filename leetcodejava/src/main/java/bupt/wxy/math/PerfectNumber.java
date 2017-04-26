package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 3/26/17.
 507. Perfect Number My SubmissionsBack To Contest
 User Accepted: 0
 User Tried: 0
 Total Accepted: 0
 Total Submissions: 0
 Difficulty: Easy
 We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 Example:
 Input: 28
 Output: True
 Explanation: 28 = 1 + 2 + 4 + 7 + 14
 Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if(num<1)return false;
        int res = 0;
        int mid = num/2;
        int start = 1;
        for(int i = mid; i>start;i--){
            if(num%i==0){
                res += num/i;
                res += i;
                if(res>num)return false;
            }
            start = num/i;
            if(num/i>=i)break;
        }
        res += 1;
        return res==num;
    }

    public static void main(String[] args){
        PerfectNumber perfectNumber = new PerfectNumber();
        System.out.print(perfectNumber.checkPerfectNumber(99999994));
    }
}
