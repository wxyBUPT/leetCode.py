package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 1/4/17.
 114. Flatten Binary Tree to Linked List   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 108505
 Total Submissions: 324065
 Difficulty: Medium
 Contributors: Admin
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */
public class FlattenBinaryTreeToLinkedList {

    // 在递归中使用共享值记录还是第一次使用
    TreeNode next=null;

    // 对于单线程有返回值可以使用私有变量代替
    public void flatten(TreeNode root) {
        if(root==null)return ;
        flatten(root.right);
        flatten(root.left);
        root.right=next;
        root.left=null;
        next=root;
    }

}
