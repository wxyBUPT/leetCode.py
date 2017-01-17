package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/8/17.
 142. Linked List Cycle II
 Total Accepted: 98986
 Total Submissions: 317496
 Difficulty: Medium
 Contributors: Admin
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycle_II {

    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)break;
        }
        if(fast==null||fast.next==null)return null;
        while (head!=slow){
            head=head.next;
            slow=slow.next;
        }
        return head;
    }
}