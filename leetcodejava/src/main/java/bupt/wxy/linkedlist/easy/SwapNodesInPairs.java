package main.java.bupt.wxy.linkedlist.easy;

/**
 * Created by xiyuanbupt on 3/12/17.
 24. Swap Nodes in Pairs
 Difficulty: Medium
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode headPre=new ListNode(0);
        headPre.next=head;
        ListNode pre=headPre;
        ListNode curr=head, first, second;
        while ((first=curr)!=null&&(second=first.next)!=null){
            curr=second.next;
            pre.next=second;
            second.next=first;
            pre=first;
            pre.next=null;
        }
        if(curr!=null)pre.next=curr;
        return headPre.next;
    }
}
