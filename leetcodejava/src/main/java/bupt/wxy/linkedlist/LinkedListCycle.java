package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 3/24/17.
 141. Linked List Cycle
 Difficulty: Easy
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)return true;
        }
        return false;
    }
}
