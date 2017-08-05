package main.java.bupt.wxy.google.kickstart2017A.squareCounting;



/**
 * Created by xiyuanbupt on 5/16/17.
 *
 */
public class Main {

    public static void main(String[] args){
        for(int i = 1; ; i++){
            if(i%11 == 8 && i % 13 == 10){
                System.out.println(i);
                break;
            }
        }
    }
}
