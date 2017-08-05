package bupt.wxy.array.easy;

/**
 * Created by xiyuanbupt on 3/12/17.
 541. Reverse String II
 Difficulty: Easy
 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
 then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"

 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] chars=s.toCharArray();
        int len=chars.length;
        int start=0;
        int end=2*k-1;
        while (end<len){
            int i=start;
            int j=start+k-1;
            reverse(chars,i,j);
            start=end+1;
            end=start+2*k-1;
        }


        int i=start, j=start+k-1;
        if(j<len){
            reverse(chars,i,j);
        }
        else {
            j=len-1;
            reverse(chars,i,j);
        }
        return new String(chars);
    }

    void reverse(char[] chars, int i, int j){
        while (i<j){
            char tmp=chars[i];
            chars[i]=chars[j];
            chars[j]=tmp;
            i++;
            j--;
        }
    }
}
