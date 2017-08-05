package wxy.engineering.laio;

import java.io.IOException;

/**
 * Created by xiyuanbupt on 4/4/17.
 */
public class TimeServer {

    public static void main(String[] args)throws IOException{
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){

            }
        }

        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
