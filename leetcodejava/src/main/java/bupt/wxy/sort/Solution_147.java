package main.java.bupt.wxy.sort;

/**
 * Created by xiyuanbupt on 1/4/17.
 147. Insertion Sort List   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 89636
 Total Submissions: 282430
 Difficulty: Medium
 Contributors: Admin
 Sort a linked list using insertion sort.

 Subscribe to see which companies asked this question
 */
public class Solution_147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)return head;
        ListNode head_pre=new ListNode(0);
        head_pre.next=head;
        ListNode curr=head.next;
        head.next=null;
        ListNode insert;
        ListNode pre;
        ListNode next;
        while (curr!=null){
            insert=curr;
            curr=curr.next;
            pre=head_pre;
            next=pre.next;
            while (next!=null&&next.val<insert.val){
                pre=pre.next;
                next=next.next;
            }
            pre.next=insert;
            insert.next=next;
        }
        return head_pre.next;
    }
}
