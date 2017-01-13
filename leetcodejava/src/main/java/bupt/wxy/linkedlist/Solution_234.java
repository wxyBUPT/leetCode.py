package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/13/17.
 234. Palindrome Linked List   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 82478
 Total Submissions: 260823
 Difficulty: Easy
 Contributors: Admin
 Given a singly linked list, determine if it is a palindrome.
 */
public class Solution_234 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=reverse(slow);
        while (slow!=null){
            System.out.println(slow.val);
            slow=slow.next;
        }
        // slow有可能比head长
        while (slow!=null&&head!=null){
            if(slow.val!=head.val)return false;
            slow=slow.next;
            head=head.next;
        }
        return true;
    }

    ListNode reverse(ListNode node){
        ListNode pre=null;
        ListNode cur=node;
        ListNode tmp;
        while (cur!=null){
            // tmp是需要被插入的节点
            tmp=cur;
            cur=cur.next;
            tmp.next=pre;
            pre=tmp;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode head=new ListNode(0);
        head.next=new ListNode(1);
        Solution_234 sl=new Solution_234();
        head=sl.reverse(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
