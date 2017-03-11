package main.java.bupt.wxy.aliCode;

/**
 * Created by xiyuanbupt on 3/9/17.
 */
public class Test {

    public static void main(String[] args){
        int x=-1;
        System.out.println(x>>>32);
        System.out.println(x>>>0);
        System.out.println(x>>32);
        System.out.println(x>>1);
        System.out.println(x>>>1);

    }

    static char[] getCharArray(byte[] arr){
        char[] carr =new char[4];
        int i=0;
        for(byte c:arr){
            carr[i]=(char)c++;
            i++;
        }
        return carr;
    }


}
