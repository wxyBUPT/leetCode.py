package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 3/24/17.
 328. Odd Even Linked List
 Difficulty: Medium
 Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedLIst {

    public ListNode oddEvenList(ListNode head) {
        int n = 0;
        ListNode oddHead = new ListNode(0);
        ListNode oddPre = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evnePre = evenHead;
        ListNode curr = head;
        while (curr != null){
            n++;
            if(n%2==1){
                oddPre.next = curr;
                oddPre = curr;
                curr = curr.next;
                oddPre.next = null;
            }else {
                evnePre.next = curr;
                evnePre = curr;
                curr = curr.next;
                evnePre.next = null;
            }
        }
        oddPre.next = evenHead.next;
        return oddHead.next;
    }
}
