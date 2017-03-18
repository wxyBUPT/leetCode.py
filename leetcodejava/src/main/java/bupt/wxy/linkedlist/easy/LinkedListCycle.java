package main.java.bupt.wxy.linkedlist.easy;

import javafx.scene.input.DataFormat;

import javax.crypto.KeyGenerator;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiyuanbupt on 3/12/17.
 141. Linked List Cycle
 Difficulty: Easy
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycle {

    private enum Test{FOO, BAR};

    public void hasCycle(ListNode head) throws NoSuchAlgorithmException, FileNotFoundException, IOException{
        ReentrantLock reentrantLock=new ReentrantLock(false);
        DateFormat dateFormat = DateFormat.getDateInstance();
        FileOutputStream fileOutputStream=new FileOutputStream("/foo/bar/text.txt");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        DataOutputStream dataOutputStream=new DataOutputStream(fileOutputStream);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("/foo/bar/text.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/foo/bar/text.txt")));
    }
}
