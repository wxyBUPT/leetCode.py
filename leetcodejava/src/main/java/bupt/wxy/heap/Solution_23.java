package main.java.bupt.wxy.heap;

/**
 * Created by xiyuanbupt on 1/13/17.
 23. Merge k Sorted Lists   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 124375
 Total Submissions: 479365
 Difficulty: Hard
 Contributors: Admin
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有时间看看败者树的实现, 败者树的实现要比mergesort 复杂很多
 * 想法不要太奇怪太复杂, 一般面试靠的算法题都能就地实现
 */
public class Solution_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        PriorityQueue<ListNode> heap=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        ListNode head_pre=new ListNode(0);
        ListNode tail=head_pre;
        for(ListNode node:lists){
            if(node!=null)heap.add(node);
        }
        while (!heap.isEmpty()){
            tail.next=heap.poll();
            tail=tail.next;
            if(tail.next!=null)heap.add(tail.next);
        }
        return head_pre.next;
    }
}
