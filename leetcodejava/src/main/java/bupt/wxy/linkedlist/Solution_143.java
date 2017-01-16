package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/16/17.
 143. Reorder List   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 82636
 Total Submissions: 335084
 Difficulty: Medium
 Contributors: Admin
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */


/**
 * 使用快慢指针, 将list分为两半, 然后reverse, 然后插入
 */
public class Solution_143 {

    public void reorderList(ListNode head) {
        if(head==null)return;
        ListNode fast=head;
        ListNode slow=head;

        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode bigger=slow.next;
        slow.next=null;
        bigger=reverse(bigger);

        while (head!=null&&bigger!=null){
            System.out.println("bigger:"+bigger.val+"head:"+head.val);
            ListNode tmp=head;
            head=head.next;
            tmp.next=bigger;
            tmp=bigger;
            bigger=bigger.next;
            tmp.next=head;
        }


    }

    // 反转链表
    ListNode reverse(ListNode head){

        ListNode pre=null;
        ListNode curr=head;
        ListNode tmp;
        while (curr!=null){
            tmp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        return pre;
    }
}
