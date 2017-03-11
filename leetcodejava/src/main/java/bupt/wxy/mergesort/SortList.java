package main.java.bupt.wxy.mergesort;


/**
 * Created by xiyuanbupt on 1/9/17.
 148. Sort List
 Total Accepted: 91401
 Total Submissions: 334775
 Difficulty: Medium
 Contributors: Admin
 Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {

    // 本题目可以使用merge sort 当然也可以利用On的空间做
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return merge(l1,l2);
    }

    ListNode merge(ListNode l1, ListNode l2){
        
        if(l1==null||l2==null)return l1==null?l2:l1;
        ListNode pre=new ListNode(0);
        ListNode curr=pre;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
                curr=curr.next;
            }
            else {
                curr.next=l2;
                l2=l2.next;
                curr=curr.next;
            }
        }
        curr.next=l1==null?l2:l1;
        return pre.next;
    }
}
