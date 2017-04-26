package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 3/24/17.
 203. Remove Linked List Elements
 Difficulty: Easy
 Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode headPre = new ListNode(0);
        ListNode curr = head;
        ListNode pre = headPre;
        while (curr!=null){
            if(curr.val != val){
                pre.next = curr;
                pre = curr;
            }
            curr = curr.next;
            pre.next = null;
        }
        return headPre.next;
    }
}
