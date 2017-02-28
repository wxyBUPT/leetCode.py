package main.java.wxy.engineering.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xiyuanbupt on 2/22/17.
 */
public class Server {

    public static void main(String[] args) throws IOException{

        int port=8899;
        // 定义一个ServerSocket 在特定端口上
        ServerSocket serverSocket=new ServerSocket(port);
        // Server 尝试接收其他Socket的链接请求, server的accept方法是阻塞式的
        System.out.println("在serverSocket.accept()之前,如果没有连接创建会一直在这里阻塞");
        Socket socket=serverSocket.accept();
        System.out.println("在serverSocket.accept()之后, reader之后");
        // 跟客户端建立好连接之后,就可以获得socket的inputstream,并从中读取客户端发送过来的消息了
        Reader reader=new InputStreamReader(socket.getInputStream());
        char chars[] = new char[64];
        int len;
        StringBuilder sb=new StringBuilder();
        while ((len=reader.read(chars))!=-1){
            sb.append(new String(chars,0,len));
        }
        System.out.println("from client: " + sb);
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
