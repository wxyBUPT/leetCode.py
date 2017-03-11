package main.java.bupt.wxy.string;

/**
 * Created by xiyuanbupt on 1/15/17.
 6. ZigZag Conversion   Add to List QuestionEditorial Solution  My Submissions
 Difficulty: Easy
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 */
public class ZigZagConversion {

    // 注意这道题的浏览器显示的不正确, 图的形状应该类似于tcp的几次握手
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++)rows[i]=new StringBuilder();
        int i_row=0;
        int inc=1;

        for(char c:s.toCharArray()){
            rows[i_row].append(c);
            if(i_row==0)inc=1;
            if(i_row==numRows-1)inc=-1;
            i_row+=inc;
        }

        StringBuilder res=new StringBuilder();
        for(StringBuilder row:rows){
            res.append(row);
        }
        return res.toString();
    }
}
