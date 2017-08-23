package bupt.wxy.string;

/**
 * Created by xiyuanbupt on 3/26/17.
 537. Complex Number Multiplication
 Difficulty: Medium
 Given two strings representing two complex numbers.

 You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

 Example 1:
 Input: "1+1i", "1+1i"
 Output: "0+2i"
 Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 Example 2:
 Input: "1+-1i", "1+-1i"
 Output: "0+-2i"
 Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 Note:

 The input strings will not have extra blank.
 The input strings will be given in the form of a+bi,
 where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class ComplexNumberMulltiplication {

    public String complexNumberMultiply(String a, String b) {
        int a_index = a.indexOf('+');
        int b_index = b.indexOf('+');
        int w=Integer.parseInt(a.substring(0,a_index)), x = Integer.parseInt(a.substring(a_index+1,a.length()-1));
        int y = Integer.parseInt(b.substring(0,b_index)), z = Integer.parseInt(b.substring(b_index+1, b.length()-1));
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(w*y-x*z)).append("+").append(w*z+x*y).append("i");
        return sb.toString();

    }

    public static void main(String[] args){
        ComplexNumberMulltiplication com = new ComplexNumberMulltiplication();
        System.out.print(com.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
