package main.java.bupt.wxy.linkedlist.easy;

/**
 * Created by xiyuanbupt on 3/12/17.
 83. Remove Duplicates from Sorted List
 Difficulty: Easy
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {

    // 19.35%
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode pre=head;
        ListNode curr=head.next;
        while (curr!=null){
            if(curr.val!=pre.val){
                pre.next=curr;
                pre=curr;
            }
            curr=curr.next;
        }
        pre.next=null;
        return head;
    }
}
