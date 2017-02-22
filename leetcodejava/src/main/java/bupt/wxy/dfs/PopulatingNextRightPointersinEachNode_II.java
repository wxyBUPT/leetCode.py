package main.java.bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 1/12/17.
 117. Populating Next Right Pointers in Each Node II
 Difficulty: Hard

 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */

/**
 * 如果让使用额外的空间使用层序遍历
 * 但是不使用层序遍历也很简单
 */
public class PopulatingNextRightPointersinEachNode_II {

    // 51.45% bugfree !!!
    public void connect(TreeLinkNode root) {
        if(root==null)return;
        root.next=null;
        TreeLinkNode head=root;
        TreeLinkNode curr;
        TreeLinkNode tmpPre=new TreeLinkNode(0);
        TreeLinkNode pre;
        while (head!=null){
            // 当前层第一个节点
            curr=head;
            // 下一层的头结点
            pre=tmpPre;
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
            pre.next=null;
            head=tmpPre.next;
        }
    }
}
