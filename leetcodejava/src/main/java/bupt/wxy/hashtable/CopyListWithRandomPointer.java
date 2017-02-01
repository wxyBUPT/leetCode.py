package main.java.bupt.wxy.hashtable;

/**
 * Created by xiyuanbupt on 1/16/17.
 138. Copy List with Random Pointer   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 92605
 Total Submissions: 347719
 Difficulty: Hard
 Contributors: Admin
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 本题目和 graph 中的133 类似, 都是深拷贝问题
 */

public class CopyListWithRandomPointer {
    Map<Integer, RandomListNode> map=new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)return null;
        if(map.containsKey(head.label))return map.get(head.label);

        RandomListNode newHead=new RandomListNode(head.label);
        map.put(head.label,newHead);
        newHead.next=copyRandomList(head.next);
        newHead.random=copyRandomList(head.random);
        return newHead;
    }

}

class RandomListNode{
    int label;
    RandomListNode next,random;
    RandomListNode(int x){
        label=x;
    }
}
