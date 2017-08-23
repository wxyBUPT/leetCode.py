package bupt.wxy.tree.easy;

import bupt.wxy.tree.TreeNode;

/**
 * Created by xiyuanbupt on 1/16/17.
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Difficulty: Medium
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int i_lo, int i_hi, int p_lo, int p_hi) {
        if (i_lo > i_hi) return null;
        TreeNode root = new TreeNode(postorder[p_hi]);
        // 找到inorder 的位置
        int index = i_lo;
        while (inorder[index] != postorder[p_hi]) index++;
        // 左子树的长度
        root.left = buildTree(i_lo, index - 1, p_lo, p_lo + index - i_lo - 1);
        root.right = buildTree(index + 1, i_hi, p_lo + index - i_lo, p_hi - 1);
        return root;
    }
}
