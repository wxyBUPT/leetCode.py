package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 3/19/17.
 538. Convert BST to Greater Tree My SubmissionsBack To Contest
 Difficulty: Easy
 Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
 5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
 18
 /   \
 20     13
 */
public class ConvertBSTToGreaterTree {

    long pre = 0;

    public TreeNode convertBST(TreeNode root) {
        preOrderRight(root);
        return root;
    }

    public void preOrderRight(TreeNode root){
        if(root==null)return;
        preOrderRight(root.right);
        root.val += pre;
        pre = root.val;
        preOrderRight(root.left);
    }
}
