package main.java.bupt.wxy.linkedlist;

/**
 * Created by xiyuanbupt on 3/1/17.
 116. Populating Next Right Pointers in Each Node Add to List
 Description  Submission  Solutions
 Total Accepted: 120904
 Total Submissions: 327639
 Difficulty: Medium
 Contributors: Admin
 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */

public class PopulationNextRightPointersInEachNode {

    // 使用层序遍历会浪费额外的空间, 应当充分利用上层节点相连的特性
    // 30%
    public void connect(TreeLinkNode root) {

        TreeLinkNode head=root;
        TreeLinkNode curr;
        TreeLinkNode head_pre=new TreeLinkNode(0);
        TreeLinkNode pre;
        while (head!=null){
            pre=head_pre;
            curr=head;
            while (curr!=null){
                if(curr.left!=null){
                    pre.next=curr.left;
                    pre=curr.left;
                }
                if(curr.right!=null){
                    pre.next=curr.right;
                    pre=curr.right;
                }
                curr=curr.next;
            }
            head=head_pre.next;
            head_pre.next=null;
        }
    }
}

class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x){
        val=x;
    }
}


