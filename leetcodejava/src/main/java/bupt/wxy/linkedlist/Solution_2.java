package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/11/17.
 2. Add Two Numbers   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 230135
 Total Submissions: 876263
 Difficulty: Medium
 Contributors: Admin
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class Solution_2 {

    // 95.77%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head_pre=new ListNode(0);
        ListNode pre=head_pre;
        while (l1!=null&&l2!=null){

            ListNode curr=new ListNode((l1.val+l2.val+carry)%10);
            carry=(l1.val+l2.val+carry)/10;
            pre.next=curr;
            pre=curr;
            l1=l1.next;
            l2=l2.next;
        }
        if(l2!=null)l1=l2;
        while (l1!=null){

            ListNode curr=new ListNode((l1.val+carry)%10);
            carry=(l1.val+carry)/10;
            pre.next=curr;
            pre=curr;
            l1=l1.next;
        }
        if(carry!=0){
            pre.next=new ListNode(carry);
        }
        return head_pre.next;

    }
}
