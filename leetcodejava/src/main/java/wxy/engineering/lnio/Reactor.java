package wxy.engineering.lnio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xiyuanbupt on 4/6/17.
 */
public class Reactor implements Runnable{

    final Selector selector;
    final ServerSocketChannel serverSocketChannel;
     Reactor(int port) throws IOException{
         selector = Selector.open();
         serverSocketChannel = ServerSocketChannel.open();
         serverSocketChannel.socket().bind(
                 new InetSocketAddress(port)
         );
         serverSocketChannel.configureBlocking(false);
         SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

         sk.attach(new Acceptor());
     }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()){
                    dispathc((SelectionKey)(it.next()));
                }
                selected.clear();
            }
        }catch (IOException e){

        }
    }

    void dispathc(SelectionKey k){
        Runnable r = (Runnable)(k.attachment());
        if(r!=null)r.run();
    }
}
