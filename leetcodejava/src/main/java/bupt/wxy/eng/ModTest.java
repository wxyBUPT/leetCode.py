package main.java.bupt.wxy.eng;

/**
 * Created by xiyuanbupt on 5/15/17.
 */
public class ModTest {

    static int MVCOUNT = 1249;
    static long MVTIME = 1000000000L;

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        int mvcount = MVCOUNT;
        long mvtime = MVTIME;
        for(long i=0;i<mvtime;i++){
            long j = 1L << mvcount;
        }
        long end = System.currentTimeMillis();
        System.out.println("Direct move: " + (end - start));

        start = System.currentTimeMillis();
        for(long i = 0; i<mvtime; i++){
            int index = mvcount % 64;
            long j = 1L << mvcount;

        }
        end = System.currentTimeMillis();
        System.out.println("Use %: " + (end - start));

    }

    public static void directMove(){
    }

}
