package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 2/1/17.
 25. Reverse Nodes in k-Group
 Difficulty: Hard
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInK_Group {

    // 84.90%
    // bugfree !!!
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1||head==null)return head;
        ListNode headPre = new ListNode(0);
        ListNode pre=headPre,curr=head;
        ListNode k_head=head, k_end;
        int i=1;
        while (curr!=null){
            if (i!=k){
                curr=curr.next;
                i++;
            }
            else {
                k_end=curr;
                curr=curr.next;
                k_end.next=null;
                pre.next=k_end;
                pre=k_head;
                reverse(k_head);
                k_head=curr;
                i=1;
            }
        }
        pre.next=k_head;
        return headPre.next;
    }

    ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        ListNode tmp;
        while (curr!=null){
            tmp=curr;
            curr=curr.next;
            tmp.next=pre;
            pre=tmp;
        }
        return pre;
    }
}
