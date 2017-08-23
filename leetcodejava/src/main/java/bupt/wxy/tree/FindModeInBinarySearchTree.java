package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 2/6/17.
 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 1
 \
 2
 /
 2
 return [2].
 */

import java.util.ArrayList;
import java.util.List;

/**
 * use inOrder keep the original order
 * 82.42%
 */
public class FindModeInBinarySearchTree {
    int curr=Integer.MIN_VALUE;
    int vote=0;
    int max=0;
    List<Integer> res=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root==null)return new int[0];
        inOrder(root);
        if(vote>max){
            res.clear();
            res.add(curr);
        }
        else if(vote==max)res.add(curr);
        int[] ret=new int[res.size()];
        for(int i=0;i<res.size();i++)ret[i]=res.get(i);
        return ret;
    }

    public void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        if(root.val==curr)vote++;
        else {
            if(vote>max){
                res.clear();
                res.add(curr);
                max=vote;
            }else if(vote==max){
                res.add(curr);
            }
            curr=root.val;
            vote=1;
        }
        inOrder(root.right);
    }
}
