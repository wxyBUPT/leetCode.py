package wxy.engineering.socket.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by xiyuanbupt on 5/7/17.
 用java 实现一个聊天室
 */
public class SocketClient extends Socket{
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 2017;

    private Socket client ;
    private PrintWriter out;
    private BufferedReader in;

    public SocketClient() throws IOException {
        super(SERVER_IP, SERVER_PORT);
        client = this;
        out = new PrintWriter(this.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(this.getInputStream()));
        new ReadLineThread();
    }

    /**
     * 用于监听服务器端想客户端发送消息线程类
     */
    class ReadLineThread extends Thread{
        private BufferedReader buff;
        public ReadLineThread(){
            try{
                buff = new BufferedReader(new InputStreamReader(client.getInputStream()));
                start();
            }catch (Exception e){

            }
        }

        @Override
        public void run() {
            try{
                while (true){
                    String result = buff.readLine();
                    if("byeClient".equals(result)){// 客户端申请退出, 服务端返回确认退出
                        break;
                    }
                    else {// 输出服务端发送过来的消息
                        System.out.println(result);
                    }
                }
                in.close();
                out.close();
                client.close();
            }catch (Exception e){

            }
        }

    }
    public static void main(String[] args){
        try{
            new SocketClient();
        }catch (Exception e){

        }
    }
}
