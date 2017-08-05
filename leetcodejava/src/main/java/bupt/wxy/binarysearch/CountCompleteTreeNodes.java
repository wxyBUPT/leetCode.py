package bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 1/12/17.
 222. Count Complete Tree Nodes

 Difficulty: Medium

 Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last,
 is completely filled, and all nodes in the last level are as far left as possible.
 It can have between 1 and 2h nodes inclusive at the last level h.
 */

public class CountCompleteTreeNodes {
    // 二分查找不一定是寻找中间的值
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int l_h=getHeight(root.left);
        int r_h=getHeight(root.right);
        if(r_h==0){
            return 1+l_h+r_h;
        }
        if(l_h==r_h){
            return powFor2(l_h)+countNodes(root.right);
        }
        else return powFor2(r_h)+countNodes(root.left);
    }

    int powFor2(int n){
        int res=2;
        while (n!=1){
            res*=2;
            n--;
        }
        return res;
    }

    int getHeight(TreeNode root){
        int res=0;
        while (root!=null){
            res++;
            root=root.left;
        }
        return res;
    }
}
