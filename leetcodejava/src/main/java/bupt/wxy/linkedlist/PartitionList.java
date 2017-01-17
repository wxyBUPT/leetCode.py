package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/7/17.
 86. Partition List
 Total Accepted: 86219
 Total Submissions: 273621
 Difficulty: Medium
 Contributors: Admin
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode less_head=new ListNode(0);
        ListNode greater_head=new ListNode(0);
        ListNode less_tail=less_head;
        ListNode greater_tail=greater_head;
        while (head!=null){
            if(head.val<x){
                less_tail.next=head;
                less_tail=head;
                head=head.next;
            }else {
                greater_tail.next=head;
                greater_tail=head;
                head=head.next;
            }
        }
        // 对两个链表拼接
        less_tail.next=greater_head.next;
        greater_tail.next=null;
        return less_head.next;
    }
}
