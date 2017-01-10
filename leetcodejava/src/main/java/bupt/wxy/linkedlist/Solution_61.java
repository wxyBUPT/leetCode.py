package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/10/17.
 61. Rotate List   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 92739
 Total Submissions: 385843
 Difficulty: Medium
 Contributors: Admin
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class Solution_61 {

    // 如果想要遍历一遍数组,按照k小于长度做
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        int len=1;
        ListNode curr=head;
        while (curr.next!=null){
            len++;
            curr=curr.next;
        }
        curr.next=head;
        k %= len;
        if(k!=0) {
            for (int i = 0; i < len - k; i++) curr = curr.next;
        }
        ListNode res=curr.next;
        curr.next=null;
        return res;

    }
}
