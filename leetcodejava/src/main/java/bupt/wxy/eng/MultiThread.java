package main.java.bupt.wxy.eng;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.BitSet;

/**
 * Created by xiyuanbupt on 5/14/17.
 */
public class MultiThread {

    public static void main(String[] args){
        // 获取Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息,
        for (ThreadInfo thread:threadInfos
             ) {
            System.out.println(thread.getThreadName());
        }
    }
}
