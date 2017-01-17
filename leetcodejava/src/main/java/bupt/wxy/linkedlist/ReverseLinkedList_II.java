package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/8/17.
 92. Reverse Linked List II
 Total Accepted: 94386
 Total Submissions: 316480
 Difficulty: Medium
 Contributors: Admin
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.


 */
public class ReverseLinkedList_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headPre=new ListNode(0);
        headPre.next=head;
        ListNode pre=headPre;
        ListNode curr=head;
        int i=1;
        while (i<m){
            pre=curr;
            curr=curr.next;
            i++;
        }

        // 反转后的尾
        ListNode tail=curr;
        // 记录前面的节点
        ListNode r_pre=null;
        ListNode tmp;
        while (i<=n){
            tmp=curr;
            curr=curr.next;
            tmp.next=r_pre;
            r_pre=tmp;
            i++;
        }

        pre.next=r_pre;
        tail.next=curr;
        return headPre.next;
    }
}
