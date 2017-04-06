package main.java.wxy.engineering.ljava;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 3/24/17.
 */
public class B extends A{
    void foo(){
        System.out.println("b_foo");
    }

    static void bar(){
        System.out.println("b_bar");
    }

    public static void main(String[] args){
        Employee employee = new Employee("123");
        System.out.println(employee.empID);

        A a = new B();
        a.foo();
        a.bar();
    }
}
class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }

}
class Employee extends Person {
    public Employee(String nm) {
        super(nm);
        // TODO Auto-generated constructor stub
    }

    String empID = "0000";
}
