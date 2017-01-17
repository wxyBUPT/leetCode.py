package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/9/17.
 82. Remove Duplicates from Sorted List II   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 94575
 Total Submissions: 330272
 Difficulty: Medium
 Contributors: Admin
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.


 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode head_pre=new ListNode(head.val-1);
        ListNode curr=head.next;

        ListNode tail=head_pre;

        while (curr!=null){
            if(curr.val==head.val){
                curr=curr.next;
            }
            else {
                if(head.next==curr){
                    tail.next=head;
                    tail=head;
                    head=head.next;
                    curr=head.next;
                }
                else {
                    head=curr;
                    curr=head.next;
                }
            }
        }
        if(head.next==null){
            tail.next=head;
            tail=head;
        }

        tail.next=null;

        return head_pre.next;

    }
}
