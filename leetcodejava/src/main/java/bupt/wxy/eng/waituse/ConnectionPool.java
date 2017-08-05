package main.java.bupt.wxy.eng.waituse;

import java.io.Closeable;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiyuanbupt on 5/15/17.
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();
    Executor executor = Executors.newCachedThreadPool();

    public ConnectionPool(int initialSize){
        if(initialSize > 0){
            for(int i = 0; i<initialSize; i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException{
        synchronized (pool){
            if(mills <= 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection res = null;
                if(!pool.isEmpty()){
                    res = pool.removeFirst();
                }
                return res;
            }
        }
    }
}

