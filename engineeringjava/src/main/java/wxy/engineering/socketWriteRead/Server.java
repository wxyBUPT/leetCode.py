package wxy.engineering.socketWriteRead;

import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by xiyuanbupt on 2/22/17.

 */
public class Server {

    public static void main(String[] args){
        Integer i = new Integer(1);
        Integer j=new Integer(1);
        System.out.println(i==j);
        System.out.println(i.equals(j));
        Integer k=Integer.valueOf(1);
        System.out.println(k==i);
        Integer l=Integer.valueOf(1);
        System.out.println(k==l);
        System.out.println(l.equals(k));
        String.valueOf(1);
    }

}
