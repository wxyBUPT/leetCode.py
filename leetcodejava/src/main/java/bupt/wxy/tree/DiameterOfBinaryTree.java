package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 3/19/17.

 543. Diameter of Binary Tree
 Difficulty: Easy
 Given a binary tree, you need to compute the length of the diameter of the tree.
 The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
 1
 / \
 2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int len = dfs(root);
        return Math.max(res, len);
    }

    public int dfs(TreeNode root){
        if(root==null)return -1;
        if(root.left==null&&root.right==null)return 0;
        int left, right;
        left = dfs(root.left) + 1;
        right = dfs(root.right) + 1;
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
