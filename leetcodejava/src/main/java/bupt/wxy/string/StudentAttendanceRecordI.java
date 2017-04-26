package main.java.bupt.wxy.string;

/**
 * Created by xiyuanbupt on 4/16/17.
 551. Student Attendance Record I My SubmissionsBack To Contest
 Difficulty: Easy
 You are given a string representing an attendance record for a student. The record only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True
 Example 2:
 Input: "PPALLL"
 Output: False
 */
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int a_c = 0, l_c = 0;
        char[] chars = s.toCharArray();
        for(char c:s.toCharArray()){
            if(c == 'A'){
                if(a_c==1)return false;
                a_c++;
                l_c = 0;
            }
            else if(c=='L'){
                if(l_c==2)return false;
                l_c++;
            }else {
                l_c = 0;
            }
        }
        return true;
    }
}
