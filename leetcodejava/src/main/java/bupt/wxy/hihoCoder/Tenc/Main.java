package main.java.bupt.wxy.hihoCoder.Tenc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println(Integer.toHexString(97));
        Integer.toHexString(97);
    }

    static void hadleLine(String str){
        char[] chars = str.toCharArray();
        int len = chars.length;
        int row = len/16 + (len%16 == 0 ? 0:1);
        int index = 0;
        for(int i=0;i<row;i++){

            while (index<len&&index - i*16 < 16){
            }
        }
    }
}
