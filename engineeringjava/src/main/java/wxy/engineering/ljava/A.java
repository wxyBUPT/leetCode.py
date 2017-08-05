package wxy.engineering.ljava;

/**
 * Created by xiyuanbupt on 3/24/17.
 */
public class A {
    void foo(){
        System.out.println("foo");
    }
    static void bar(){
        System.out.println("bar");
    }

    A(){
        bar();
    }
}

