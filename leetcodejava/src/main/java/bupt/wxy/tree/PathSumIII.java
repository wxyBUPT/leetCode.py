package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 1/13/17.
 437. Path Sum III

 Difficulty: Easy

 You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 对于这种简单题目我可有想法了
 * 这种题目还可以使用二叉树的递归遍历,借助于hashmap存储从跟节点访问到当前节点拥有的所有长度
 */
public class PathSumIII {

    //80.26% 现在没有灵性啊!!!!
    public int pathSum1(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    int helper(TreeNode root, int sum, int target, Map<Integer, Integer> preSum) {
        if (root == null) return 0;
        sum += root.val;
        int res = preSum.getOrDefault(sum - target, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        res += helper(root.left, sum, target, preSum) + helper(root.right, sum, target, preSum);
        preSum.put(sum, preSum.get(sum) - 1);
        return res;
    }

    //46.83%
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int findPath(TreeNode root, int sum) {
        int res = 0;
        if (root == null)
            return res;
        if (sum == root.val)
            res++;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
}
