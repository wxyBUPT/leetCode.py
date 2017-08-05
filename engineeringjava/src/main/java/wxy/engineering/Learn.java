package wxy.engineering;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 3/2/17.
 */
public class Learn {

    public static void main(String[] args){
        int cont = 0;
        for(int i = 1;i<=10000; i++){
            if(is(i))cont++;
        }
        System.out.println(cont);
    }

    private static boolean is(int i){
        String s = String.valueOf(i);
        boolean contains6_8 = false;
        boolean contains4 = false;
        for(char c:s.toCharArray()){
            if(c=='4'){
                return false;
            }
            else if(c=='6' || c=='8'){
                contains6_8 = true;
            }
        }
        return contains6_8;
    }
}
