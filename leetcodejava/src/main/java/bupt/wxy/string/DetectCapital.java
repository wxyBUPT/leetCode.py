package bupt.wxy.string;

/**
 * Created by xiyuanbupt on 2/26/17.
 520. Detect Capital
 Given a word, you need to judge whether the usage of capitals in it is right or not.
 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.
 Example 1:
 Input: "USA"
 Output: True
 Example 2:
 Input: "FlaG"
 Output: False

 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if(word.length()==0)return true;
        if(Character.isUpperCase(word.charAt(0))){
            if(word.length()==1)return true;
            if(Character.isUpperCase(word.charAt(1))){
                for(char c:word.toCharArray()){
                    if(!Character.isUpperCase(c))return false;
                }
                return true;
            }
            else {
                for(int i=2;i<word.length();i++){
                    if(Character.isUpperCase(word.charAt(i)))return false;
                }
                return true;
            }
        }
        else {
            for(char c:word.toCharArray()){
                if(Character.isUpperCase(c))return false;
            }
            return true;
        }
    }

    public static void main(String[] args){
        System.out.println('c'-'C');
        System.out.println((char)('A'-1));
    }
}
