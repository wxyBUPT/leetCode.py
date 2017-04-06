package main.java.wxy.engineering.lnio;

import java.io.IOException;

/**
 * Created by xiyuanbupt on 3/23/17.
 */
public class TimeServer {

    public static void main(String[] args) throws IOException{
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                // 采用默认值
            }
        }

    }
}
