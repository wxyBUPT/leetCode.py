package main.java.bupt.wxy.linkedlist;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 3/24/17.
 445. Add Two Numbers II
 Difficulty: Medium
 You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7

 */
public class AddTwoNumbersII {

    // 可以反转列表, 但是按照题目意思不可以改变链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode curr = l1;
        while (curr != null){
            s1.push(curr.val);
            curr = curr.next;
        }
        curr = l2;
        while (curr!=null){
            s2.push(curr.val);
            curr = curr.next;
        }
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty())sum += s1.pop();
            if(!s2.isEmpty())sum += s2.pop();
            list.val = sum %10;
            ListNode head = new ListNode(sum/10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        return list.val == 0 ? list.next : list;
    }
}
