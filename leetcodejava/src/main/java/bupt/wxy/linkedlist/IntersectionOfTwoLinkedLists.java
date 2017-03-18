package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 1/13/17.
 160. Intersection of Two Linked Lists
 Difficulty: Easy
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 */
public class IntersectionOfTwoLinkedLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode a=headA,b=headB;
        while (a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a;
    }

    public ListNode getIntersectionNodewithlen(ListNode headA, ListNode headB) {

        //
        ListNode a=headA;
        ListNode b=headB;
        int a_len=0;
        int b_len=0;
        while (a!=null){
            a_len++;
            a=a.next;
        }
        while (b!=null){
            b_len++;
            b=b.next;
        }
        if(a_len>b_len){
            int diff=a_len-b_len;
            while (diff--!=0){
                headA=headA.next;
            }
        }else {
            int diff=b_len-a_len;
            while (diff--!=0){
                headB=headB.next;
            }
        }
        while (headA!=null&&headB!=null&&headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
