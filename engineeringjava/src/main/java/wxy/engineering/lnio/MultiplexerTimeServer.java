package main.java.wxy.engineering.lnio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;

/**
 * Created by xiyuanbupt on 3/23/17.
 1. 创建ServerSocketChannle 配置为非阻塞模式
 2. 坚挺绑定, 配置TCP参数, 例如backlog大小
 3. 创建一个独立的I/O线程,用于轮训多路复用器Selector
 4. 创建Selector, 将之前创建的ServerSocketChannle注册到Selector上, 坚挺SelectionKey.ACCEPT
 6. 当轮训到就绪状态的Channel的时候, 需要对其进项判断, 如果是OP_ACCEPT 状态, 说明是新的客户端接入, 则调用ServerSocketChannel.accept() 方法接收新的客户端
 7. 设置新的客户端链路SocketChannel为费阻塞模式, 配置一些TCP参数
 8. 将SocketChannle注册到Selector, 监听OP_READ 操作位
 9. 如果轮训到的Channel为OP_READ,则说明SocketChannel中有新的就绪数据报需要读取, 则构造ByteBuffer对象, 读取数据报
 10. 如果轮训的Channel 为OP_WRIT, 说明还有数据没有发送完成, 需要继续发送
 */
public class MultiplexerTimeServer {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    /**
     * 初始化多路复用器, 绑定监听端口
     * @param port
     */
    public MultiplexerTimeServer(int port){
        try{
            selector = Selector.open();
            // 打开ServerSocketChannel, 用于监听客户端连接, 他是所有客户端连接的父管道
            serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("The time server is start in port: " + port);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    private void handleInput(SelectionKey key) throws IOException{
        if(key.isValid()) {
            if (key.isAcceptable()) {
                // Read the data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order : " + body);
                    String currentTime = "QUERY TIME ORDER".equals(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                } else {

                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException{

    }

    public static void main(String[] args){
        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(8080);
    }


}
