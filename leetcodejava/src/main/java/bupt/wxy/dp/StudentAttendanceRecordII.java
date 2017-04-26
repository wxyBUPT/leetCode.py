package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 4/16/17.
 552. Student Attendance Record II My SubmissionsBack To Contest
 User Accepted: 63
 User Tried: 151
 Total Accepted: 63
 Total Submissions: 333
 Difficulty: Hard
 Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

 A student attendance record is a string that only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 Example 1:
 Input: n = 2
 Output: 8
 Explanation:
 There are 8 records with length 2 will be regarded as rewardable:
 "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 Only "AA" won't be regarded as rewardable owing to more than one absent times.
 */

/**
 * 第一反应是使用dp来计算
 */
public class StudentAttendanceRecordII {
    final long K = 1000000007L;

    public int checkRecord(int n) {
        if(n==0)return 0;
        long[] a_used_l_0 = new long[n];
        long[] a_used_l_1 = new long[n];
        long[] a_used_l_2 = new long[n];
        long[] a_emp_l_0 = new long[n];
        long[] a_emp_l_1 = new long[n];
        long[] a_emp_l_2 = new long[n];
        a_used_l_0[0] = 1;
        a_emp_l_0[0] = 1;
        a_emp_l_1[0] = 1;
        for(int i = 1; i < n; i++){
            // 当前位置为P
            a_used_l_0[i] += a_used_l_1[i-1] + a_used_l_2[i-1] + a_used_l_0[i-1];
            a_emp_l_0[i] += a_emp_l_1[i-1] + a_emp_l_0[i-1] + a_emp_l_2[i-1];
            // 当前位置未L
            a_used_l_1[i] += a_used_l_0[i-1];
            a_used_l_2[i] += a_used_l_1[i-1];
            a_emp_l_1[i] += a_emp_l_0[i-1];
            a_emp_l_2[i] += a_emp_l_1[i-1];
            // 当前位置为A
            a_used_l_0[i] += a_emp_l_0[i-1]+a_emp_l_1[i-1] + a_emp_l_2[i-1];
        }
        long total = a_used_l_0[n-1] + a_used_l_1[n-1] + a_used_l_2[n-1] + a_emp_l_0[n-1] + a_emp_l_1[n-1] + a_emp_l_2[n-1];
        System.out.println(total);
        return (int)(total%K);
    }

    public static void main(String[] args){
        StudentAttendanceRecordII st = new StudentAttendanceRecordII();
        System.out.println(st.checkRecord(100));
    }
}
