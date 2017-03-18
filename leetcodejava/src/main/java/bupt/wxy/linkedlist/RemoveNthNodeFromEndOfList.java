package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 3/12/17.
 19. Remove Nth Node From End of List
 Difficulty: Medium
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headPre=new ListNode(0);
        headPre.next=head;
        ListNode curr=head;
        while (n>0){
            curr=curr.next;
            n--;
        }
        ListNode pre=headPre;

        while (curr!=null){
            curr=curr.next;
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return headPre.next;

    }
}
