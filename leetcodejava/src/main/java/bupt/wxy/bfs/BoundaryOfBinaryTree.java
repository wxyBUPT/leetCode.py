package main.java.bupt.wxy.bfs;

/**
 * Created by xiyuanbupt on 3/26/17.
 545. Boundary of Binary Tree My SubmissionsBack To Contest
 Difficulty: Medium
 Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

 Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

 The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

 The right-most node is also defined by the same way with left and right exchanged.

 Example 1
 Input:
 1
 \
 2
 / \
 3   4

 Ouput:
 [1, 3, 4, 2]

 Explanation:
 The root doesn't have left subtree, so the root itself is left boundary.
 The leaves are node 3 and 4.
 The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 Example 2
 Input:
 ____1_____
 /          \
 2            3
 / \          /
 4   5        6
 / \      / \
 7   8    9  10

 Ouput:
 [1,2,4,7,8,9,10,6,3]

 Explanation:
 The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 The leaves are node 4,7,8,9,10.
 The right boundary are node 1,3,6,10. (10 is the right-most node).
 So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 */

import java.util.*;

/**
 * 觉得是一个简单的bfs
 * 脑子不灵光啊
 */
public class BoundaryOfBinaryTree {

    public boolean isLeaf(TreeNode t){
        return t.left == null && t.right == null;
    }

    public void addLeaves(List<Integer> res, TreeNode root){
        if(isLeaf(root)){
            res.add(root.val);
        }else {
            if(root.left!=null){
                addLeaves(res, root.left);
            }
            if(root.right!=null){
                addLeaves(res, root.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        if(!isLeaf(root)){
            res.add(root.val);
        }
        TreeNode t = root.left;
        while (t!=null){
            if(!isLeaf(t)){
                res.add(t.val);
            }
            if(t.left!=null){
                t=t.left;
            }else {
                t = t.right;
            }
        }

        addLeaves(res, root);

        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t!=null){
            if(!isLeaf(t)){
                s.push(t.val);
            }
            if(t.right!=null){
                t = t.right;
            }else {
                t = t.left;
            }
        }
        while (!s.isEmpty()){
            res.add(s.pop());
        }
        return res;
    }



    /**
     * 一下方法都是自己意淫的, 正确的代码在上面
    boolean[] left_used;
    boolean[] right_used;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        int h = getHeight(root);
        left_used = new boolean[h];
        right_used = new boolean[h];
        List<Integer> res = new LinkedList<>();
        if(root==null)return res;
        res.add(root.val);
        preOrder(root.left, 1, res);
        postOrder(root.right, 1, res.size(), res);
        return res;
    }

    void preOrder(TreeNode root, int depth, List<Integer> res){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            res.add(root.val);
            left_used[depth] = true;
            return;
        }
        if(!left_used[depth]){
            left_used[depth]=true;
            res.add(root.val);
        }
        preOrder(root.left, depth+1, res);
        preOrder(root.right, depth+1, res);
    }

    private int getHeight(TreeNode root){
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return 1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


    void postOrder(TreeNode root, int depth, int index, List<Integer> res){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            res.add(index, root.val);
            right_used[depth] = true;
            return;
        }
        if(!right_used[depth]){
            right_used[depth] = true;
            res.add(index, root.val);
        }
        postOrder(root.right, depth+1, index, res);
        postOrder(root.left, depth+1, index, res);
    }
     **/


    /**
     void levelAdd(TreeNode root, List<Integer> res){

     List<List<Integer>> levels = levelOrder(root);
     if(levels.size()==0)return;
     int len = levels.size();
     List<Integer> last = levels.get(len-1);
     for(Integer i:last)res.add(i);
     for(int i=len-2; i>=0; i--){
     List<Integer> level = levels.get(i);
     if(level.size()>0){
     res.add(level.get(level.size()-1));
     }
     }
     }
     **/

    /**
    private List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res=new LinkedList<>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int levelSize=0;
        while (!queue.isEmpty()){
            levelSize=queue.size();
            List<Integer> levelVals=new LinkedList<>();
            TreeNode tmp;
            for(int i=0;i<levelSize;i++){
                tmp=queue.poll();
                levelVals.add(tmp.val);
                if(tmp.left!=null)queue.offer(tmp.left);
                if(tmp.right!=null)queue.offer(tmp.right);
            }
            res.add(levelVals);
        }
        return res;
    }
     **/



    /**
    public List<Integer> boundaryOfBinaryTreeWrong(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> levels = levelOrder(root);
        int len = levels.size();
        for(int i=0;i<len-1;i++){
            res.add(levels.get(i).get(0));
        }
        if(len>1) {
            for (Integer i : levels.get(len - 1)) res.add(i);
        }
        for(int i=len-2;i>0;i--){
            List<Integer> level = levels.get(i);
            if(level.size()>1){
                res.add(level.get(level.size()-1));
            }
        }
        return res;
    }


     **/

}
