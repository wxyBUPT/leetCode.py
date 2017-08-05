package main.java.bupt.wxy.eng.waituse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * Created by xiyuanbupt on 5/15/17.
 */
public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("commit")){

            }
            return null;
        }
    }

    public static final Connection createConnection(){
        return null;
    }
}
