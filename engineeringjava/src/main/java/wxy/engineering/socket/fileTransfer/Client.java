package wxy.engineering.socket.fileTransfer;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * Created by xiyuanbupt on 5/7/17.
 */
public class Client {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 2017;

    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;

    public Client(){
        try{
            try {
                client = new Socket(SERVER_IP, SERVER_PORT);
                File file = new File("/");
                fis = new FileInputStream(file);
                dos = new DataOutputStream(client.getOutputStream());
                // 文件名和长度
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();

                // 传输文件
                byte[] sendBytes = new byte[1024];
                int len = 0;
                while ((len = fis.read(sendBytes, 0, sendBytes.length))>0){
                    dos.write(sendBytes, 0, len);
                    dos.flush();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                if (fis != null) fis.close();
                if (dos != null) dos.close();
                client.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
