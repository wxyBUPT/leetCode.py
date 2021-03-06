package main.java.bupt.wxy.norecursion;

/**
 * Created by xiyuanbupt on 1/8/17.
 236. Lowest Common Ancestor of a Binary Tree   Add to List QuestionEditorial Solution  My Submissions
 Difficulty: Medium

 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2       0       8
 /  \
 7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用后序遍历的非递归方式
 */
public class LonwestCommonAncestorOfABinaryTree {

    //
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> p_path=new ArrayList<>(),q_path=new ArrayList<>();
        TreeNode curr=root;
        while (!stack.isEmpty()||curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }

            while (!stack.isEmpty()&&stack.peek().right==curr){
                curr=stack.peek();
                // 访问curr节点
                if(curr==p)p_path=new ArrayList<>(stack);
                if(curr==q)q_path=new ArrayList<>(stack);
                stack.pop();
            }

            if(stack.isEmpty())curr=null;
            else curr=stack.peek().right;
        }
        int i=0;
        int len=Math.min(p_path.size(),q_path.size());
        while (i<len&&p_path.get(i)==q_path.get(i)){
            i++;
        }
        return p_path.get(i-1);
    }

    // 找到其中任意一个节点位置, 或者找到两个节点最低的公共祖先
    // 然后利用相关逻辑来判断
    public TreeNode recursion(TreeNode root, TreeNode p, TreeNode q){
        if(root==null||root==p||root==q)return root;
        TreeNode left=recursion(root.left,p,q);
        TreeNode right=recursion(root.right,p,q);
        // 左边能找到相关节点么? 右面能找到相关节点么?如果同时找到了节点则不能再低了,如果一边找到了节点,则能更加第
        return left==null?right:right==null?left:root;
    }
}
