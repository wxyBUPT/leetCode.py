package bupt.wxy.string;

/**
 * Created by xiyuanbupt on 4/9/17.
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i = 0;
        int j = 0;
        while (j<=len){
            if(chars[j]!=' '){
                j++;
                continue;
            }
            else {
                reverse(chars, i, j - 1);
                i = j+1;
                j = j+1;
            }
        }
        reverse(chars, i, len-1);
        return new String(chars);
    }

    public void reverse(char[] chars, int i, int j){
        if(j<=i)return;
        while (i<j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}
