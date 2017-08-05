package wxy.engineering.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.channels.Selector;

/**
 * Created by xiyuanbupt on 2/22/17.
 */
public class Client {

    public static void main(String[] args) throws IOException{
        // 为了简单,所有异常都向外抛
        String host="127.0.0.1";
        int port=8899;
        // 与服务器简历socket连接
        Socket client=new Socket(host,port);
        Writer writer=new OutputStreamWriter(client.getOutputStream());
        writer.write("Hello Server.");
        System.out.println("想服务器发送了一些东西");
        writer.flush();// 写完后记得flush
        writer.close();
        client.close();
        Selector selector = Selector.open();
    }
}
