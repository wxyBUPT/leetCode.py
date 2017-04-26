package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 3/24/17.
 206. Reverse Linked List
 Difficulty: Easy
 Reverse a singly linked list.

 click to show more hints.

 Hint:
 A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    // 使用递归的方法翻转链表
    ListNode pre = null;
    public ListNode reverseListre(ListNode head) {
        if(head == null)return pre;
        ListNode next = head.next;
        head.next = pre;
        pre = head;
        return reverseListre(next);
    }

    // 使用非递归的方法翻转链表
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        ListNode tmp ;
        while (curr!=null){
            tmp = curr;
            curr = curr.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }
}
