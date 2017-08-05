package wxy.engineering.socket.fileTransfer;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xiyuanbupt on 5/7/17.
 */
public class Server {

    private static final int PORT = 2017;

    private ServerSocket serverSocket;
    private Socket client ;
    private DataInputStream dis;
    private FileOutputStream fos;

    // 就是通过DataInputStream 和 FileOutputStream 读取文件什么的
    public Server() throws Exception{

    }
}
